package com.sp.admin

import java.util.Date;

import com.sp.domain.GodAppItem

class AdminGodAppItemController {


	static allowedMethods = [save: "POST",activate:"POST"]
	//主程序支持：渠道号，母程序版本号，注册日期，最后访问日期

	def list(Integer max) {

		if(!checkDate(params)){

			return [godAppItemInstanceList: [],errorInfo :"请输入时间段,起始相同视为无效"]

		}


		def q=GodAppItem.where{};

		if(params.csDate&&params.ceDate&&!params.csDate.equals(params.ceDate)){
			q=q.where{
				dateCreated>=params.csDate&&dateCreated<params.ceDate
			}
		}

		if(params.vsDate&&params.veDate&&!params.vsDate.equals(params.veDate)){
			q=q.where{
				lastUpdated>=params.vsDate&&lastUpdated<params.veDate
			}
		}
		//				if(params.imei){
		//					q=q.where{imei==params.imei}
		//
		//				}
		//				if(params.imsi){
		//					q=q.where{imsi==params.imsi}
		//
		//				}
		if(params.channelCode){
			if(params.channelCode.length()==3){
				def cd_min=(params.channelCode as Integer)*1000
				def cd_max=cd_min+999
				q=q.where{channelCode>=cd_min&&channelCode<=cd_max}
			}else if(params.channelCode.length()==6){
				q=q.where{channelCode==params.channelCode as Integer}

			}

		}
		if(params.appVersion){
			q=q.where{appVersion==params.appVersion}

		}

		//				if(params.phoneNumber){
		//					q=q.where{phoneNumber==params.phoneNumber}
		//
		//				}

		//				Date dateCreated
		//				Date lastUpdated
		//				Date activeDate




		params.sort='id'
		params.order='desc'
		params.max = Math.min(max ?: 1000, 1000)
		def result=q.list(params)
		[godAppItemInstanceList: result]
	}

	private checkDate(params){
		boolean flag=false;
		if(params.csDate&&params.ceDate&&!params.csDate.equals(params.ceDate)){//create start date
			flag=true
		}else if(params.vsDate&&params.veDate&&!params.vsDate.equals(params.veDate)){//visit start date
			flag=true
		}
		flag

	}


	private datePlus(sdate,plusv){
		Calendar c=Calendar.getInstance();
		if(!sdate){
			c.set(Calendar.DAY_OF_MONTH,1);
			c.set(Calendar.HOUR_OF_DAY,0)
			c.set(Calendar.MINUTE,0);
			c.set(Calendar.SECOND,0)
			c.set(Calendar.MILLISECOND,0)
			sdate=c.getTime()
		}else{
			c.setTime(sdate);
		}


		int endMonth=c.get(Calendar.MONTH)+1;
		c.set(Calendar.MONTH, endMonth)
		Date enddate=c.getTime()-1;
	}
}
