package com.sp.admin

import com.sp.service.AppService

class AdminPhoneAreaMapController {

    AppService appService

    def load() {
        appService.loadPnAreaMap()
        flash.message = "完成加载号段表"
        redirect(action: "index")
    }


    def index() {
        def result = appService.pnAreaMapSize()
        def dataList = appService.pnAreaCountMap

        [result: result, data: dataList]
    }

//    def areaCanalMap() {
//        def m = appService.getAreaCanalMap();
//
//        def showMap = [:]
//        if (m != null) {
//            m.each { key, value ->
//                if (key != null && value != null && value instanceof Canal) {
//                    if (key instanceof String) {
//                        if (key.contains("1")) {
//                            key = key.replace("1", "移动")
//                        } else if (key.contains("2")) {
//                            key = key.replace("2", "联通")
//                        } else if (key.contains("3")) {
//                            key = key.replace("3", "电信")
//                        }
//                    }
//
//                    showMap.put(key, value.name)
//                }
//            }
//        }
//
//        def localList = []
//        localList.add(["local":"北京", "value":"北京"])
//        localList.add(["local":"辽宁", "value":"辽宁"])
//        localList.add(["local":"辽宁-沈阳", "value":"辽宁-沈阳"])
//
//        [m: showMap, localList: localList]
//    }
//
//    def loadAreaCanalMap() {
//        appService.loadAreaCanalMap()
//        flash.message = "完成加载areaCanalMap"
//        redirect(action: "areaCanalMap")
//    }

}
