package com.sp.admin

import com.sp.service.AppService

class AdminPhoneAreaMapController {

	AppService appService

	def load() {

		appService.loadPnAreaMap()
		flash.message = "完成加载号段表"
		redirect(action: "index")
	}


	def index(){
		def result=appService.pnAreaMapSize()
		[result:result]
	}
	
	
	def areaCanalMap(){
		def m=appService.getAreaCanalMap();
		[m:m]
	}
	
	def loadAreaCanalMap(){
		appService.loadAreaCanalMap()
		flash.message = "完成加载areaCanalMap"
		redirect(action: "areaCanalMap")
	}
	
}
