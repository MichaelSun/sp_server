package com.sp.domain

class SdkCanal extends Canal{
	
	
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
    }
}
