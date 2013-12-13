package com.sp.domain

import java.util.Date;

class Channel {
	String name
	int mainCode
	int rate
	int rateBegin
	int activeDelay//分钟

	Date dateCreated
	Date lastUpdated

	static constraints = {
		rateBegin nullable: true
	}

	public String toString(){
		this.properties.toString()+" id:"+id
	}

	static mapping ={ mainCode index:'mainCode' }
}
