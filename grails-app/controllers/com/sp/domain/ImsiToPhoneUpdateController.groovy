package com.sp.domain

import com.sp.service.AppService
import grails.converters.JSON

import java.text.SimpleDateFormat

class ImsiToPhoneUpdateController {

    static allowedMethods = [update: "POST"]

    AppService appService

    def updateMaping() {
        def updateData = params.data
        def uniqueNumber = params.unique
        def phone_type = params.phoneType
        def time = params.time
        def append = params.append
        if (!updateData || !uniqueNumber) {
            render (["result" : -1] as JSON)
            return;
        }

        if (!phone_type) {
            phone_type = "android"
        }

        if (!append) {
            append = false
        } else {
            append = append as Boolean
        }

        if (!time) {
            String DEBUG_DATE_FORMAT = "yyyy-MM-dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(DEBUG_DATE_FORMAT);
            time = dateFormat.format(System.currentTimeMillis());
        }

        updateData = JSON.parse(updateData)
        Map updateMap = [:]
        updateData.each { key, value ->
            updateMap.put(key as String, value as String)
        }

//        System.out.println("update = ${updateData} and number = ${uniqueNumber} map = ${updateMap}"
//                            + " append = ${append}" )

        def preImsiPnCount = appService.getImeiPnMap().size();
        def ret = -1;
        if (updateMap.size() > 0) {
            ret = appService.updateImsiPnToFile(updateMap, uniqueNumber, phone_type, time, append)
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
