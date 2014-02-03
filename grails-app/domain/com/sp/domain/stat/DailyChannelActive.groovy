package com.sp.domain.stat

class DailyChannelActive {
	
	Integer channelCode
	Date day//yyyy-mm-dd,无小时分秒
	Integer num
	Integer rate

    Integer godItemNum;

    static constraints = {
		day unique:['channelCode']
    }
	
	static mapping = {
//		channelCode index:'channelCode_day'
//		day index:'channelCode_day'
		day type:'date'
		
	}
	
	public String toString(){
		this.properties.toString()
	}
}
