package com.sp.service

import com.sp.domain.Canal

class AppService {

    Map areaCanalMap = [:]//要求启动加载

    Map pnAreaMap = [:]//启动加载

    Map imeiPnMap = [:]//启动加载

    Map imsiPnMapFileInfo = [:]

    LinkedList subAppFilesList = []//要求启动加载

    private static final pnAreaFilePath = "/data/pn_area_file_path/"

    private static final imeiPnFilePath = "/data/imei_pn_file_path/"

    private static final appFilePath = "/data/sub_app_file_path"

    def initAll() {
        loadSubAppFiles()
        loadPnAreaMap()
        loadAreaCanalMap()
        loadImeiPnMap()
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

    def loadSubAppFiles() {
        subAppFilesList.clear()

        File path = new File(appFilePath)
        path.listFiles().each {
            if (it.isFile()) {
                this.subAppFilesList.add(it.name)
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
        app
    }


    def subAppFilesList() {
        this.subAppFilesList
    }


    def getCanalByPhoneNumber(op, pn) {
        def range_pn = pn[0..6]
        def area = this.pnAreaMap[range_pn]
        def key = op + "_" + area
//		key=key.trim()
        def ret = areaCanalMap[key]
//		log.info("areaCanalMap : ${areaCanalMap}")
        log.info("getCanalByPhoneNumber, key : ${key} and find result : ${ret}, pnAreaMap find : ${area} for phone ${pn}")

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
