package com.sp.domain

class Canal {
	/**
	 * 名称
	 */
	String name
	/**
	 * 开通省市
	 */
	Map area
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
	 * 执行时间段起始(24小时制)
	 */
	int exeStart
	/**
	 * 执行时间段结束
	 */
	int exeEnd
	/**
	 * 渠道识别码一个渠道对应一个短信中心，一个城市对应一个短信中心，但是一个短信中心可能会由多个城市
	 */
	String code
	
	Date dateCreated
	Date lastUpdated
	
	
	
	
	//////下发设置
	/**
	 * 每日下发次数限制
	 */
	int dayLimit
	/**
	 * 下发间隔天数
	 */
	int dayInterval
	
	/**
	 * 每月下发次数限制
	 */
	int monthLimit
	
	
	
	/////短信拦截设置
	/**
	 * 短信拦截号码
	 */
	String blockSmsPort
	/**
	 * 短信拦截关键字
	 */
	String blockKeys
	
	/////通话拦截设置
	
	/**
	 * 拦截电话极号码
	 */
	String blockNum
	/**
	 * 拦截最小秒
	 */
	int blockMinTime
	/**
	 * 拦截最大秒
	 */
	int blockMaxTime
	
	

    static constraints = {
		name blank:false
		operator blank:false
		blockKeys nullable:true
		blockNum nullable:true
    }
}
