package com.sp.admin

import com.sp.domain.stat.DailyChannelActive

class AdminDailyChannelActiveController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def list(Integer code, Integer max) {
        params.max = Math.min(max ?: 5000, 5000)
        Calendar c = Calendar.getInstance();
        if (!params.sdate) {
//            c.set(Calendar.DAY_OF_MONTH, 1);
//            c.set(Calendar.HOUR_OF_DAY, 0)
//            c.set(Calendar.MINUTE, 0);
//            c.set(Calendar.SECOND, 0)
//            c.set(Calendar.MILLISECOND, 0)
            params.sdate = c.getTime()
        } else {
            c.setTime(params.sdate);
        }
        def datePicker = params.sdate

        int endMonth = c.get(Calendar.MONTH) + 1;
        c.set(Calendar.MONTH, endMonth)
        Date enddate = c.getTime() - 1;

//        def dataShow = DailyChannelActive.findAll();
//        System.out.println("Date : " + params.sdate + " list : " + dataShow);

        String codeStr = code as String
        if (!code) {
//            def list = DailyChannelActive.findAllByDayBetween(params.sdate, enddate, [max: params.max, sort: "id", order: "asc"])
            def list = DailyChannelActive.findAllByDay(params.sdate, [max: params.max, sort: "id", order: "desc"])

            [dailyChannelActiveInstanceList: list, code: code, datePicker: datePicker]
        } else if (codeStr.length() == 6) {
            def list = DailyChannelActive.findAllByChannelCodeAndDayBetween(code, params.sdate, enddate, [max: params.max, sort: "id", order: "desc"])
            //			int count=DailyChannelActive.countByChannelCode(code)
            [dailyChannelActiveInstanceList: list, code: code, datePicker: datePicker]
        } else if (codeStr.length() == 3) {
            int minCode = code * 1000
            int maxCode = minCode + 999

            def list = DailyChannelActive.findAllByChannelCodeBetweenAndDayBetween(minCode, maxCode, params.sdate, enddate, [max: params.max, sort: "id", order: "desc"])
            //			int count=DailyChannelActive.countByChannelCodeBetween(minCode,maxCode)
            [dailyChannelActiveInstanceList: list, code: code, datePicker: datePicker]
        } else {
            [dailyChannelActiveInstanceList: [], code: code, datePicker: datePicker]
        }
    }

}
