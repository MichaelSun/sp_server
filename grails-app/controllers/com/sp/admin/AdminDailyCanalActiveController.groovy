package com.sp.admin

import com.sp.domain.stat.DailyCanalActive
import com.sp.domain.stat.DailyChannelActive

class AdminDailyCanalActiveController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

   

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [dailyCanalActiveInstanceList: DailyCanalActive.list(params), dailyCanalActiveInstanceTotal: DailyCanalActive.count()]
    }

}
