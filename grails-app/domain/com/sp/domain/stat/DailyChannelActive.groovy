package com.sp.domain.stat

class DailyChannelActive {
	
	Integer channelCode
	Date day//yyyy-mm-dd,无小时分秒
	Integer num
	Integer rate

    Integer godItemNum;

    Double rateNumber; // num * rate，使用这种方式就可以是将转化率实时的计算进入

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
