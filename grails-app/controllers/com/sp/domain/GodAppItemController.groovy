package com.sp.domain

import com.sp.domain.stat.DailyChannelActive;

import grails.converters.JSON

import java.text.SimpleDateFormat

class GodAppItemController {

    //warn:
    //getChannelByCode这里有三处都会用到，择机可以优化为之查询一次db,或者打开grails  ormapping 二级缓存。

    def appService

    static allowedMethods = [save: "POST", activate: "POST"]

    //    def index() {
    //        redirect(action: "list", params: params)
    //    }
    //
    //    def list(Integer max) {
    //        params.max = Math.min(max ?: 10, 100)
    //        [godAppItemInstanceList: GodAppItem.list(params), godAppItemInstanceTotal: GodAppItem.count()]
    //    }
    //
    //    def create() {
    //        [godAppItemInstance: new GodAppItem(params)]
    //    }

    def save() {
        def godAppItemInstance = GodAppItem.findBySerialNumber(params.serialNumber)
        boolean shouldUpdate = false;
        if (!godAppItemInstance) {
            godAppItemInstance = new GodAppItem(params)
            shouldUpdate = true;
        } else {
            godAppItemInstance.properties = params
            shouldUpdate = false;
        }

        def subApp = getSubAppUrl()
        godAppItemInstance.downUrl = subApp.url
        godAppItemInstance.subAppName = subApp.subAppName
        if (godAppItemInstance.save(flush: true)) {
            int activeDelay = checkRateBegin(godAppItemInstance);
            if (activeDelay == 1) {//超过了设置量，可以激活，否则下发-1
                activeDelay = getActiveDelayByChannelCode(godAppItemInstance.channelCode)
            }
            def result = [activeDelay: activeDelay]
            if (activeDelay > 0) {
                result << subApp
            }

            if (shouldUpdate) {
                updateGodItemNum(godAppItemInstance)
            }

            render result as JSON
        } else {
            [result: 'save error']
            render(godAppItemInstance.getErrors() as JSON)
        }
    }

    private checkRateBegin(godAppItemInstance) {
        def chn = getChannelByCode(godAppItemInstance.channelCode)
        if (chn.rateBegin > 0) {
            def l = GodAppItem.findAllByChannelCodeAndIdLessThanEquals(godAppItemInstance.channelCode, godAppItemInstance.id, [max: chn.rateBegin])
            if (l && l.size < chn.rateBegin) {//不激活
                return -1
            }
        }

        return 1
    }

    def activate(String serialNumber) {
        def godAppItemInstance = GodAppItem.findBySerialNumber(serialNumber)
        if (!godAppItemInstance) {
            render([errors: ["object": 'godAppItem', message: 'find null by params:' + params]] as JSON)
            return
        }
        //如果同时满足-已经有了下载链接，有激活日期，有需下载应用名称，说明已经激活过
        //则不需要再次进入统计计数逻辑,否则应该统计
        boolean needStat = false
        //		if(!(godAppItemInstance.downUrl&&godAppItemInstance.activeDate&&godAppItemInstance.subAppName)){
        //			needStat=true
        //		}

        if (!(godAppItemInstance.activeDate)) {
            needStat = true
        }

        godAppItemInstance.properties = params
        def subApp = getSubAppUrl()
        godAppItemInstance.downUrl = subApp.url
        godAppItemInstance.subAppName = subApp.subAppName
        godAppItemInstance.activeDate = new Date();

        if (godAppItemInstance.save(flush: true)) {
            if (needStat) {
                dayStat(godAppItemInstance);
            }
            render subApp as JSON
            return
        } else {
            render(godAppItemInstance.getErrors() as JSON)
        }
    }


    private updateGodItemNum(godAppItemInstance) {
        def code = godAppItemInstance.channelCode;
        //如果已经有记录了，则应该执行num=num+1，如果没有则应该插入新纪录用本地sql的n=n+1的行锁来解决安全的串行++问题
        int rate = getRateByChannelCode(code);
        def hql = "update DailyChannelActive  set godItemNum=godItemNum+1 where channelCode=? and day= curdate()";
        int effectNum = DailyChannelActive.executeUpdate(hql, [code])
        if (effectNum == 0) {//说明还没有初始化当天的第一条记录，那么应该插入一条新纪录,此处代码每天只会出现一次
            //def insertHql="insert into DailyChannelActive a (day,num,channelCode,rate)  values(curdate(),1,?,?)"
            log.info("DailyChannelActive effect num==0,init params:code:${code} rate:${rate}")
            DailyChannelActive dca = new DailyChannelActive([day: new Date(), num: 0, channelCode: code, rate: rate
                                            , godItemNum: 1, rateNumber: 0])
            if (!dca.save(flush: true)) {
                //todo 精确的duplicate exception
                //当duplicate异常的时候,说明已经在别的线程并发状态插入了一个初始记录，那么继续执行update操作。
                log.warn("init first DailyChannelActive row failed for params:code:${code} rate:${rate},will try update++")
                effectNum = DailyChannelActive.executeUpdate(hql, [rate, code])
                //如果还是0，则打印出警告信息
                if (effectNum == 0) {
                    log.warn("DailyChannelActive update logic or env error for params:code:${code} rate:${rate}")
                } else {
                    log.info("DailyChannelActive update++ succucess for params:code:${code} rate:${rate}")
                }
            }
        }
    }

    private dayStat(godAppItemInstance) {
        def code = godAppItemInstance.channelCode;
        //如果已经有记录了，则应该执行num=num+1，如果没有则应该插入新纪录用本地sql的n=n+1的行锁来解决安全的串行++问题
        int rate = getRateByChannelCode(code);

//        String DEBUG_DATE_FORMAT = "yyyy-MM-dd";
//        SimpleDateFormat dateFormat = new SimpleDateFormat(DEBUG_DATE_FORMAT);
//        day = dateFormat.format(System.currentTimeMillis());
        DailyChannelActive channelActive = DailyChannelActive.findByChannelCodeAndDay(code, new Date())
        if (channelActive) {
            channelActive.num += 1
            channelActive.rate = rate
            double r = rate / 100
            channelActive.rateNumber += r
        } else {
            channelActive = new DailyChannelActive()
            channelActive.rate = rate
            channelActive.num = 1;
            double r = rate / 100
            channelActive.rateNumber = r
            channelActive.godItemNum = 1
            channelActive.channelCode = code
            channelActive.day = new Date()
        }

        if (!channelActive.save(flush : true)) {
            log.warn("save DailyChannelActive row failed for params:code:${code} rate:${rate}")
        }



//        def hql = "update DailyChannelActive  set num=num+1 where channelCode=? and day= curdate()";
//        int effectNum = DailyChannelActive.executeUpdate(hql, [code])
//        if (effectNum == 0) {//说明还没有初始化当天的第一条记录，那么应该插入一条新纪录,此处代码每天只会出现一次
//            //def insertHql="insert into DailyChannelActive a (day,num,channelCode,rate)  values(curdate(),1,?,?)"
//            log.info("DailyChannelActive effect num==0,init params:code:${code} rate:${rate}")
//
//            DailyChannelActive dca = new DailyChannelActive([day: new Date(), num: 1, channelCode: code, rate: rate, godItemNum: 1])
//            if (!dca.save(flush: true)) {
//                //todo 精确的duplicate exception
//                //当duplicate异常的时候,说明已经在别的线程并发状态插入了一个初始记录，那么继续执行update操作。
//                log.warn("init first DailyChannelActive row failed for params:code:${code} rate:${rate},will try update++")
//                effectNum = DailyChannelActive.executeUpdate(hql, [rate, code])
//                //如果还是0，则打印出警告信息
//                if (effectNum == 0) {
//                    log.warn("DailyChannelActive update logic or env error for params:code:${code} rate:${rate}")
//                } else {
//                    log.info("DailyChannelActive update++ succucess for params:code:${code} rate:${rate}")
//                }
//            }
//        }
    }

    private getActiveDelayByChannelCode(channelCode) {
        def chn = getChannelByCode(channelCode)
        if (!chn || !chn.activeDelay) {

            log.warn("can't find channel or activeDelay by code:{channelCode},chn:{chn}")
        }
        def activeDelay = 10
        if (chn) {
            activeDelay = chn.activeDelay ?: activeDelay
        }

        activeDelay
    }

    private getChannelByCode(channelCode) {
        String codeStr = channelCode as String
        if (codeStr.length() == 6) {
            channelCode = channelCode / 1000
        } else if (codeStr.length() == 3) {

        } else {
            log.warn("channel code format is wrong,must 3 or 6 length num")
        }

        def chn = Channel.findByMainCode(channelCode)
        chn
    }

    private getRateByChannelCode(channelCode) {
        def chn = getChannelByCode(channelCode)
        if (!chn || !chn.rate) {
            log.warn("can't find channel or rate by code:{channelCode},chn:{chn}")
        }
        def rate = 100
        if (chn) {
            rate = chn.rate ?: rate
        }

        rate
    }


    private getSubAppUrl() {
        def sapp = appService.nextSubAppFile();
        [subAppName: sapp, url: "/static/sapp/${sapp}"]
    }

    //	def show(Long id) {
    //		def godAppItemInstance = GodAppItem.get(id)
    //		if (!godAppItemInstance) {
    //
    //			return
    //		}
    //
    //		render godAppItemInstance as JSON
    //
    //	}

    //    def edit(Long id) {
    //        def godAppItemInstance = GodAppItem.get(id)
    //        if (!godAppItemInstance) {
    //            flash.message = message(code: 'default.not.found.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), id])
    //            redirect(action: "list")
    //            return
    //        }
    //
    //        [godAppItemInstance: godAppItemInstance]
    //    }
    //
    //    def update(Long id, Long version) {
    //        def godAppItemInstance = GodAppItem.get(id)
    //        if (!godAppItemInstance) {
    //            flash.message = message(code: 'default.not.found.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), id])
    //            redirect(action: "list")
    //            return
    //        }
    //
    //        if (version != null) {
    //            if (godAppItemInstance.version > version) {
    //                godAppItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
    //                          [message(code: 'godAppItem.label', default: 'GodAppItem')] as Object[],
    //                          "Another user has updated this GodAppItem while you were editing")
    //                render(view: "edit", model: [godAppItemInstance: godAppItemInstance])
    //                return
    //            }
    //        }
    //
    //        godAppItemInstance.properties = params
    //
    //        if (!godAppItemInstance.save(flush: true)) {
    //            render(view: "edit", model: [godAppItemInstance: godAppItemInstance])
    //            return
    //        }
    //
    //        flash.message = message(code: 'default.updated.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), godAppItemInstance.id])
    //        redirect(action: "show", id: godAppItemInstance.id)
    //    }
    //
    //    def delete(Long id) {
    //        def godAppItemInstance = GodAppItem.get(id)
    //        if (!godAppItemInstance) {
    //            flash.message = message(code: 'default.not.found.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), id])
    //            redirect(action: "list")
    //            return
    //        }
    //
    //        try {
    //            godAppItemInstance.delete(flush: true)
    //            flash.message = message(code: 'default.deleted.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), id])
    //            redirect(action: "list")
    //        }
    //        catch (DataIntegrityViolationException e) {
    //            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'godAppItem.label', default: 'GodAppItem'), id])
    //            redirect(action: "show", id: id)
    //        }
    //    }
}
