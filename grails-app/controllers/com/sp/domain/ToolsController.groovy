package com.sp.domain

import grails.converters.JSON

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import com.sp.service.AppService

class ToolsController {
	
	Log csvLogger=LogFactory.getLog("logger.csv.i2n")

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	AppService  appService
	def i2n(String imei) {
		def pn =appService.getPnByImei(imei);
		if(!pn){
			pn=-1
		}
		csvLogger.info "${imei},${pn}"
		render ([pn:pn] as JSON)
	}
}
