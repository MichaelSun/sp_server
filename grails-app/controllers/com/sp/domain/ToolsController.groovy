package com.sp.domain

import com.sp.service.AppService;

import grails.converters.JSON

class ToolsController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	AppService  appService
	def i2n(String imei) {
		def pn =appService.getPnByImei(imei);
		render ([pn:pn] as JSON)
	}
}
