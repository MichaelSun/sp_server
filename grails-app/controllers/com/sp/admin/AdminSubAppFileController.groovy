package com.sp.admin

import grails.converters.JSON

import com.sp.service.AppService

class AdminSubAppFileController {
	
	AppService appService

    def load() {
		
		def loadList=appService.loadSubAppFiles()
		render (loadList as JSON)
		
	}
	
	
	
}
