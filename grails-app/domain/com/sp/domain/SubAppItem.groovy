package com.sp.domain

import java.util.Date;

class SubAppItem {


	String imei
	String imsi
	int channelCode
	int netType
	String appVersion
	String name
	String serialNumber
	String smsCenter
//	int area//省市前三位省，后三位市
	String phoneType
	String osVersion
	String canalInfo
	String phoneNumber
	String error
	String extra



	Date dateCreated
	Date lastUpdated



	/**客户端激活时的扣费状态信息
	 * 用来与通道中相关设置做比较，此处只是做一下记录。
	 * 比较发生在在请求参数运行时
	 */
	int monthChargeCount
	int  dayChargeCount
	long lastChargeTime


	static constraints = { 
		serialNumber unique:true
		
		canalInfo maxSize:512
		
	}
	static mapping = {
		
		extra nullable:true
		error nullable:true
		
		
	}
	
	public String toString(){
		"${this.id},${this.properties}"
	}
}
