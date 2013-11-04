package com.sp.admin

import org.springframework.dao.DataIntegrityViolationException

import com.sp.domain.stat.DailyChannelActive

class AdminDailyChannelActiveController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

   

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [dailyChannelActiveInstanceList: DailyChannelActive.list(params), dailyChannelActiveInstanceTotal: DailyChannelActive.count()]
    }

}
