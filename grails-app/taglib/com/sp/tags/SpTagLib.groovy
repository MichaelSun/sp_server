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
}
