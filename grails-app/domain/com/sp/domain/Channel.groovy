package com.sp.domain

import java.util.Date;

class Channel {
	String name
	int mainCode
	int rate
	int activeDelay//分钟
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
    }
	
	public String toString(){
		this.properties.toString()+" id:"+id
	}
}
