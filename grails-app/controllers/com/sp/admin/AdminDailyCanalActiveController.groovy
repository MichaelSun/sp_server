package com.sp.admin

import com.sp.domain.stat.DailyCanalActive

class AdminDailyCanalActiveController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def list(String canalName, Integer max) {
        params.max = Math.min(max ?: 5000, 5000)
        Calendar c = Calendar.getInstance();
        if (!params.sdate) {
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.set(Calendar.HOUR_OF_DAY, 0)
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0)
            c.set(Calendar.MILLISECOND, 0)
            params.sdate = c.getTime()
        } else {
            c.setTime(params.sdate);
        }
        def datePicker = params.sdate

        int endMonth = c.get(Calendar.MONTH) + 1;
        c.set(Calendar.MONTH, endMonth)
        Date enddate = c.getTime() - 1;

//        Date enddate = params.sdate

        def result = []
        if (params.canalName) {
            result = DailyCanalActive.findAllByCanalNameAndDayBetween(params.canalName, params.sdate, enddate, [max: params.max, sort: "id", order: "desc"])
//            result = DailyCanalActive.findAllByCanalNameAndDay(params.canalName, params.sdate, [max: params.max, sort: "id", order: "desc"])
        } else {
//            result = DailyCanalActive.findAllByDayBetween(params.sdate, enddate, [max: params.max, sort: "id", order: "desc"])
            result = DailyCanalActive.findAllByDay(params.sdate, [max: params.max, sort: "id", order: "desc"])
        }

        [dailyCanalActiveInstanceList: result, datePicker: datePicker]
    }
}
