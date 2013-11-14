package com.sp.domain.stat

class DailyCanalActive {
	
	String canalName
	Date day//yyyy-mm-dd,无小时分秒
	Integer num

    static constraints = {
		day unique:['canalName']
    }
	
	static mapping = {
		day type:'date'
		
	}
	
	public String toString(){
		this.properties.toString()
	}
}
