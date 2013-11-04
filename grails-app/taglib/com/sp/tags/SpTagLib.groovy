package com.sp.tags

class SpTagLib {
	static namespace = "sp"
	
	def canalType = { attrs, body ->
		out << body() << getType(attrs)
		
	}
	
	def canalTypeEn = { attrs, body ->
		out<< body()<<getEnType(attrs)
		
	}
	
	private getType(attrs){
		if(attrs.type.endsWith('SmsCanal' )){
			"短信通道"
		}else if(attrs.type.endsWith('WapCanal' )){
		"wap通道"
		}else if(attrs.type.endsWith('SdkCanal' )){
		"sdk通道"
		}else{
		
		printf "taglib canalType missing match type："+attrs.type
		
		}
	}
	
	private getEnType(attrs){
		def t=attrs.type.replaceAll(".*\\.", "")
		t
	}
	
	def rater={attrs, body ->
//		if(!attrs.rate){
//			attrs.rate=100
//		}
//		double r=attrs.rate/100
//		if(!attrs.num){
//		attrs.num=0	
//		}
//		out << body() << (attrs.num*r as Integer)
		out << body() << caculateRateNum(attrs.num, attrs.rate)
		
	}
	
	def rateListNum={attrs, body ->
		
		def result=0
		attrs.rows.each {
			
			result+=caculateRateNum(it.num,it.rate)
		}
		
		
		out << body() << (result)
		
	}
	
	private caculateRateNum(num,rate){
		num=num?:0
		rate=rate?:100
		double r=rate/100
		//			result=result+(n*r as Integer)
		Math.round(num*r)
		
	}
	
	
}
