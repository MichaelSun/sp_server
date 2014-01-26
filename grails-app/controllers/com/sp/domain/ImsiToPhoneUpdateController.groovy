package com.sp.domain

import com.sp.service.AppService
import grails.converters.JSON

class ImsiToPhoneUpdateController {

    static allowedMethods = [update: "POST"]

    AppService appService

    def updateMaping() {
        def updateData = params.data
        def uniqueNumber = params.unique
        if (!updateData || !uniqueNumber) {
            render (["result" : -1] as JSON)
            return;
        }
        updateData = JSON.parse(updateData)
        Map updateMap = [:]
        updateData.each { key, value ->
            updateMap.put(key as String, value as String)
        }

//        System.out.println("update = ${updateData} and number = ${uniqueNumber} map = ${updateMap}")

        def preImsiPnCount = appService.getImeiPnMap().size();
        def ret = -1;
        if (updateMap.size() > 0) {
            ret = appService.updateImsiPnToFile(updateMap, uniqueNumber)
        }

        if (ret > 0) {
            def data =  ["result" : ret, "uploadCont" : updateMap.size(), "orgCount" : preImsiPnCount] as JSON
            render data
            return
        } else {
            render (["result" : -1] as JSON)
        }

        return
    }
}
