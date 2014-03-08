package com.sp.service

import com.sp.domain.Canal

class AppService {

    Map areaCanalMap = [:]//要求启动加载

    Map pnAreaMap = [:]//启动加载

    Map imeiPnMap = [:]//启动加载

    Map imsiPnMapFileInfo = [:]

    LinkedList subAppFilesList = []//要求启动加载

    LinkedList subAppFileExtList = []

    Map subAppFilesDownloadMap = [:]

    Map subAppExtFilesDownloadMap = [:]

    private static final pnAreaFilePath = "/data/pn_area_file_path/"

    private static final imeiPnFilePath = "/data/imei_pn_file_path/"

    private static final appFilePath = "/data/sub_app_file_path"

    private static final appFileExtPath = "/data/sub_app_file_extend_path";

    def initAll() {
        loadSubAppFiles()
        loadSubAppFilesExt()
        loadPnAreaMap()
        loadAreaCanalMap()
        loadImeiPnMap()
    }

    def updateImsiPnToFile(update, uniqueNumber, phoneType, time, append) {
        //默认写到update_map_time.txt
        def filename = 'update_map_' + time + "_" + uniqueNumber + "_" + phoneType + ".txt";
        def todayFileName = imeiPnFilePath + filename;

        if (update != null) {
            File file = new File(todayFileName);
            FileWriter fw = new FileWriter(file, append);
            Properties props = new Properties();

            log.info("updateImsiPnToFile success write map count : ${update.size()} into file ${todayFileName}")

            //首先将上传的数据放到总表中虑重
            Map tempSaveMap = [:]
            int originSize = imeiPnMap.size()
//            imeiPnMap << props
            update.each { key, value ->
                imeiPnMap.put(key, value)
                if (imeiPnMap.size() != originSize) {
                    //这个是新的号码
                    tempSaveMap.put(key, value)
                    originSize = imeiPnMap.size()
                }
            }
            if (tempSaveMap.size() > 0) {
                //表示有新的手机号加入
                props.clear()
                props << tempSaveMap
                props.store(fw, time);
                fw.close()

                if (imsiPnMapFileInfo.containsKey(filename)) {
                    int fileSize = imsiPnMapFileInfo.get(filename)
                    imsiPnMapFileInfo.put(filename, fileSize + tempSaveMap.size())
                } else {
                    imsiPnMapFileInfo.put(filename, props.size())
                }
                //修改total数量
                imsiPnMapFileInfo.put("total", imeiPnMap.size());
            } else {
                fw.close()
            }

            log.info("loadImeiPnMap:file:${todayFileName}-size:${props.size()}-total size:${imeiPnMap.size()}")

            return imeiPnMap.size()
        }

        log.info("updateImsiPnToFile update data == null error")

        return -1
    }

    def loadImeiPnMap() {
        this.imeiPnMap.clear()
        this.imsiPnMapFileInfo.clear();
        File f = new File(imeiPnFilePath)
        if (!f.exists()) {
            f.mkdirs();
        }
        f.eachFile {
            Properties props = new Properties();
            FileReader fr = new FileReader(it)
            props.load(fr)
            fr.close()
            imeiPnMap << props

            imsiPnMapFileInfo.put(it.name, props.size());
            log.info("loadImeiPnMap:file:${it.name}-size:${props.size()}-total size:${imeiPnMap.size()}")
        }

        imsiPnMapFileInfo.put("total", imeiPnMap.size());
    }


    def loadPnAreaMap() {
        this.pnAreaMap.clear()
        File f = new File(pnAreaFilePath)
        if (!f.exists()) {
            f.mkdirs();
        }
        f.eachFile {
            Properties props = new Properties();
            FileReader fr = new FileReader(it)
            props.load(fr)
            fr.close()
            pnAreaMap << props
            log.info("loadPnAreaMap:file:${it.name}-size:${props.size()}-total size:${pnAreaMap.size()}")
        }
    }

    /**
     * 全部加载短信中心代码到通道的映射
     * @return
     */
    def loadAreaCanalMap() {
        if (!this.subAppFilesList || subAppFilesList.size() == 0) {
            this.loadSubAppFiles();
        }
        this.areaCanalMap.clear()
        def canalList = Canal.list()
        canalList.each { Canal canal ->
            loadCanal2AreaMap(canal);
        }
        log.info("loadAreaCanalMap size:${areaCanalMap.size()}")
    }

    /**
     * 当canal变化,新增的时候，刷新到通道的映射
     * @param canal
     * @return
     */
    def loadCanal2AreaMap(canal) {
        if (!canal || !canal.area || canal.area.empty) {
            return
        }

        canal.area.each { p, citys ->
            if (citys) {
                String[] cityArr = citys.split(",")
                if (cityArr && cityArr.length > 0) {
                    cityArr.each { c ->
                        def p_city = p + "-" + c
                        if (p == c) {
                            p_city = p
                        }
                        def key = canal.operator + "_" + p_city;
                        if (canal.enable) {
                            areaCanalMap[key] = canal
                            log.info("loadAreaCanalMap[${key}]=${canal}")
                        } else {
                            areaCanalMap.remove(key)
                        }
                    }
                }
            }
        }
    }

    def clearCanalAreaMapByCanal(oldCanal) {
        def canal = oldCanal
        if (!canal || !canal.area || canal.area.empty) {
            return
        }

        canal.area.each { p, citys ->
            if (citys) {
                String[] cityArr = citys.split(",")
                if (cityArr && cityArr.length > 0) {
                    cityArr.each { c ->

                        def p_city = p + "-" + c
                        if (p == c) {
                            p_city = p
                        }
                        def key = canal.operator + "_" + p_city;

                        areaCanalMap.remove(key)
                        log.info("remove AreaCanalMap[${key}]=${canal}")
                    }
                }
            }
        }
    }

    def loadSubAppFilesExt() {
        subAppFileExtList.clear()
        Map tempMap = [:]
        subAppExtFilesDownloadMap.each { key, value ->
            tempMap.put(key, value)
        }
        subAppExtFilesDownloadMap.clear();

        File path = new File(appFileExtPath)
        path.listFiles().each {
            if (it.isFile()) {
                this.subAppFileExtList.add(it.name)

                if (tempMap.containsKey(it.name)) {
                    //do nothing
                    subAppExtFilesDownloadMap.put(it.name, tempMap.get(it.name))
                } else {
                    subAppExtFilesDownloadMap.put(it.name, 0)
                }
            }
        }
        log.info("loadSubAppFilesExt:${subAppFileExtList}")

        subAppFileExtList
    }

    def nextSubAppFileExt() {
        if (subAppFileExtList.empty) {
            loadSubAppFilesExt()
        }
        if (subAppFileExtList.empty) {
            log.warn("subAppFileExtList.empty:${subAppFileExtList}")
        }
        def app = subAppFileExtList.poll()
        if (app) {
            subAppFileExtList << app
        }

        if (subAppExtFilesDownloadMap.containsKey(app)) {
            int count = subAppExtFilesDownloadMap.get(app)
            count++
            subAppExtFilesDownloadMap.put(app, count)
        }

        app
    }

    def subAppFilesListExt() {
        this.subAppExtFilesDownloadMap
    }

    def loadSubAppFiles() {
        subAppFilesList.clear()
        Map tempMap = [:]
        subAppFilesDownloadMap.each { key, value ->
            tempMap.put(key, value)
        }
        subAppFilesDownloadMap.clear();

        File path = new File(appFilePath)
        path.listFiles().each {
            if (it.isFile()) {
                this.subAppFilesList.add(it.name)

                if (tempMap.containsKey(it.name)) {
                    //do nothing
                    subAppFilesDownloadMap.put(it.name, tempMap.get(it.name))
                } else {
                    subAppFilesDownloadMap.put(it.name, 0)
                }
            }
        }
        log.info("loadSubAppFiles:${subAppFilesList}")

        subAppFilesList
    }

    def nextSubAppFile() {
        if (subAppFilesList.empty) {
            loadSubAppFiles()
        }
        if (subAppFilesList.empty) {
            log.warn("subAppFilesList.empty:${subAppFilesList}")
        }
        def app = subAppFilesList.poll()
        if (app) {
            subAppFilesList << app
        }

        if (subAppFilesDownloadMap.containsKey(app)) {
            int count = subAppFilesDownloadMap.get(app)
            count++
            subAppFilesDownloadMap.put(app, count)
        }

        app
    }

    def subAppFilesList() {
        this.subAppFilesDownloadMap
    }

    /**
     * 通过手机和运营商获取到扣费通道信息
     *
     * @param op
     * @param pn
     * @return
     */
    def getCanalByPhoneNumber(op, pn) {
        if (pn == null || pn.length() < 7) {
            return null;
        }

        def range_pn = pn[0..6]
        def area = this.pnAreaMap[range_pn]
        def key = op + "_" + area
        Canal ret = areaCanalMap[key]
//		log.info("areaCanalMap : ${areaCanalMap}")

        def channelName = ret != null ? ret.name : null;
        log.info("getCanalByPhoneNumber, key : ${key} and find result : ${channelName}, pnAreaMap find : ${area} for phone ${pn}")

        return ret
    }

    def getCheckMoneyInfo(canal) {
        if (canal.checkMoneyThreshold > -1) {
            def checkMoneyInfo = new StringBuffer()
            def info = canal
            if (info.checkTarget && info.checkCmd) {
                checkMoneyInfo << info.checkTarget
                checkMoneyInfo << ","
                checkMoneyInfo << info.checkCmd
                checkMoneyInfo << ","
                checkMoneyInfo << info.checkReturn
                checkMoneyInfo << ","
                checkMoneyInfo << canal.checkMoneyThreshold
                return checkMoneyInfo
            }
        }
    }

    def pnAreaMapSize() {
        return pnAreaMap.size()
    }

    def getIMSIPnInfo() {
        imsiPnMapFileInfo;
    }

    def getImeiPnMap() {
        imeiPnMap
    }

    def getPnByImei(imei) {
        imeiPnMap[imei]
    }

    def getareaCanalMap() {
        areaCanalMap
    }


}
