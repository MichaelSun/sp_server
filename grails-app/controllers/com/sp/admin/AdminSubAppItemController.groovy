package com.sp.admin

import com.sp.domain.SubAppItem

class AdminSubAppItemController {


	static allowedMethods = [save: "POST",activate:"POST"]

	def list(Integer max) {
		//渠道号，版本号，网络类型，注册时间


		if(!checkDate(params)){

			return [subAppItemInstanceList: [],errorInfo :"请输入时间段,起始相同视为无效"]

		}

		def q=SubAppItem.where{};


		if(params.csDate&&params.ceDate&&!params.csDate.equals(params.ceDate)){
			q=q.where{
				dateCreated>=params.csDate&&dateCreated<=params.ceDate
			}
		}


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
		if(params.netType&&params.netType!='0'){
			q=q.where{netType==params.netType}

		}
		def result=q.list(params)
		params.max = Math.min(max ?: 10, 100)
		[subAppItemInstanceList: result]


	}
	
//	private getMainCode(code){ 
//		def mainCode=0
//		if(code){
//			String codeStr=attrs.code as String
//			if(codeStr.length()==6){
//				mainCode=codeStr.substring(0, 3)
//			}else if(codeStr.length()==3){
//			mainCode=codeStr as Integer
//			}
//		}else{
//			mainCode=-1
//		}
//		out<< body()<<mainCode
//	}

	private checkDate(params){
		boolean flag=false;
		if(params.csDate&&params.ceDate&&!params.csDate.equals(params.ceDate)){//create start date
			flag=true
		}
		flag

	}
}
