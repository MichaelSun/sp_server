package com.sp.domain

import java.util.Date;

class GodAppItem {
	
	
	String imei
	String imsi
	int channelCode
	String appVersion
	Date dateCreated
	Date lastUpdated 
	int netType
	Date activeDate
	String downUrl
	String subAppName
	String serialNumber
	String phoneNumber

	

    static constraints = {
		downUrl nullable: true
		activeDate nullable :true 
		subAppName nullable :true
		serialNumber unique: true
		
    }
}
