package com.sp.domain.stat

import org.springframework.dao.DataIntegrityViolationException

class StatDailyChannelActiveController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]


	//	def list(Integer max) {
	//		params.max = Math.min(max ?: 10, 100)
	//		[dailyChannelActiveInstanceList: DailyChannelActive.list(params), dailyChannelActiveInstanceTotal: DailyChannelActive.count()]
	//	}

	def codeList(Integer code) {


		params.max = Math.min(params.max ?: 10, 100)


		Calendar c=Calendar.getInstance();
		if(!params.sdate){
			c.set(Calendar.DAY_OF_MONTH,1);
			c.set(Calendar.HOUR_OF_DAY,0)
			c.set(Calendar.MINUTE,0);
			c.set(Calendar.SECOND,0)
			c.set(Calendar.MILLISECOND,0)
			params.sdate=c.getTime()
		}else{
			c.setTime(params.sdate);
		}
		def datePicker=params.sdate


		int endMonth=c.get(Calendar.MONTH)+1;
		c.set(Calendar.MONTH, endMonth)
		Date enddate=c.getTime()-1;

		String codeStr=code as String
		if(!code){

			[dailyChannelActiveInstanceList:[],code:code,datePicker:datePicker,msg:"您输入的代码有误，请确认"]

		}
		else if(codeStr.length()==6){

			def list= DailyChannelActive.findAllByChannelCodeAndDayBetween(code,params.sdate,enddate,[max: params.max, sort: "id", order: "asc"])
			//			int count=DailyChannelActive.countByChannelCode(code)
			[dailyChannelActiveInstanceList:list, code:code,datePicker:datePicker]
		}else if(codeStr.length()==3){
			int minCode=code*1000
			int maxCode=minCode+999

			def list= DailyChannelActive.findAllByChannelCodeBetweenAndDayBetween(minCode,maxCode,params.sdate,enddate,[max: params.max, sort: "id", order: "asc"])
			//			int count=DailyChannelActive.countByChannelCodeBetween(minCode,maxCode)
			[dailyChannelActiveInstanceList:list,code:code,datePicker:datePicker]
		}else{

			[dailyChannelActiveInstanceList:[],code:code,datePicker:datePicker]
		}
	}
}
