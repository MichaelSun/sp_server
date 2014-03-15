package com.sp.domain

import grails.converters.JSON
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class StatisticsController {

    static allowedMethods = [pluginSMSStatus: "POST"]

    Log csvLogger = LogFactory.getLog("logger.csv.pluginSMSStatus")

    def pluginSMSStatus() {
        //        渠道号    IMEI    手机型号    操作系统  运营商编号   是否双卡
        //        检测SIM卡是否成功   发送激活短信是否成功    手机号码
        //        发送短信失败原因
        def fromId = params.fromId
        def imei = params.imei

        if (!fromId || !imei) {
            render (["result" : -1] as JSON)
            return;
        }

        if (csvLogger) {
            csvLogger.info "${fromId},${imei},${params.phoneType},${params.os},${params.opt},${params.twoCard}" +
                    ",${params.simCard},${params.activeSMS},${params.phoneNum},${params.smsStatus}"
        }

        return render (["result" : 1] as JSON)
    }

}
