package com.sp.domain

import java.util.Date;

class Channel {
	String name
	int mainCode
	int rate
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
    }
	
	public String toString(){
		this.properties.toString()+" id:"+id
	}
}
