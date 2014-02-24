package com.sp.domain

import com.sp.service.AppService
import grails.converters.JSON
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import java.text.SimpleDateFormat

class ImsiToPhoneUpdateController {

    static allowedMethods = [update: "POST", phoneInstall: "POST"]

    AppService appService

    Log csvLogger = LogFactory.getLog("logger.csv.pluginInstall")

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

    def phoneInstall() {
//        渠道号    IMEI    手机型号    操作系统  运营商编号   是否双卡   检测SIM卡是否成功   发送激活短信是否成功    手机号码   装机软件数     装机软件编号    留存软件数   留存软件编号    装机日期    当前日期
        def fromId = params.fromId
        def imei = params.imei

        if (!fromId || !imei) {
            render (["result" : -1] as JSON)
            return;
        }

        if (csvLogger) {
            csvLogger.info "${fromId},${imei},${params.phoneType},${params.os},${params.opt},${params.twoCard}" +
                    ",${params.activeSMS},${params.phoneNum},${params.softwareCount},${params.softwareInfo}" +
                    ",${params.leftSoftwareCount},${params.leftSoftwareInfo},${params.installTime}"
        }

        return render (["result" : 1] as JSON)
    }
}
