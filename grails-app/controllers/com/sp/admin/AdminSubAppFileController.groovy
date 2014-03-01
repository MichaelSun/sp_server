package com.sp.admin

import com.sp.service.AppService

class AdminSubAppFileController {

    AppService appService

    def load() {
        def list = appService.loadSubAppFiles()
        def extList = appService.loadSubAppFilesExt()
        flash.message = "完成加载${list.size()}条记录"
        redirect(action: "list")
    }

    def list() {
        def subItemMapInfo = appService.subAppFilesList()
        [mapInfo: subItemMapInfo, count: subItemMapInfo.size()]
    }

}
