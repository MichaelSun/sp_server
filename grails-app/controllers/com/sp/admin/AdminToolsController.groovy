package com.sp.admin

import com.sp.service.AppService

class AdminToolsController {

    AppService appService

    def loadImeiPn() {
        appService.loadImeiPnMap()
        flash.message = "完成加载"
        redirect(action: "i2n")
    }

    def i2n() {
//        def data = appService.getImeiPnMap()
//        [result: data.size()]
        def data = appService.getIMSIPnInfo()
        [result: data]
    }
}
