package com.sp.domain

class Canal {
	/**
	 * 名称
	 */
	String name
	/**
	 * 开通省份
	 */
	String province
	/**
	 * 开通城市
	 */
	String city
	/**
	 * 运营商
	 */
	String operator
	/**
	 * 生效
	 */
	boolean enable
	/**
	 * 执行次数
	 */
	int times
	/**
	 * 执行间隔
	 */
	int interval
	/**
	 * 执行时间段起始
	 */
	int exeStart
	/**
	 * 执行时间段结束
	 */
	int exeEnd
	
	Date dateCreated
	Date lastUpdated

    static constraints = {
		name blank:false
		operator blank:false
		province blank:false
		
    }
}
