package com.sp.admin

import grails.converters.JSON

import com.sp.service.AppService

class AdminSubAppFileController {
	
	AppService appService

    def load() {
		
		def list=appService.loadSubAppFiles()
		flash.message = "完成加载${list.size()}条记录"
		redirect(action: "list")
		
	}
	
	
	def list(){
		def list=appService.list()
		
		 [list:list,count:list.size()]
		
	}
	
	
	
}
