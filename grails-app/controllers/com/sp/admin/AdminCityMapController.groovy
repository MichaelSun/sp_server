package com.sp.admin

import com.sp.service.AppService

class AdminCityMapController {

	AppService appService

	def load() {

		appService.loadCityMap()
		flash.message = "完成加载cityMap"
		redirect(action: "index")
	}


	def index(){
		def result=appService.getCityMap()
		[result:result]
	}
}
