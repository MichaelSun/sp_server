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
    int operator
    /**
     * 生效
     */
    boolean enable
    /**
     * 执行次数
     */
    Integer times
    /**
     * 执行间隔
     */
    Integer interval
    /**
     * 执行时间段起始(24小时制)
     */
    Integer exeStart
    /**
     * 执行时间段结束
     */
    Integer exeEnd
    /**
     * 渠道识别码一个渠道对应一个短信中心，一个城市对应一个短信中心，但是一个短信中心可能会由多个城市
     */
    //	String code

    Date dateCreated
    Date lastUpdated

    /**
     * 短信端口（短信类型专有数据）
     */
    String port
    String instruction

    /**
     * wap类型专有数据
     */
    String wapInfo
    /**
     * 类型
     */
    int t

    /**
     * 每日下发次数限制，天
     *
     * 对于一个设备来说的
     */
    Integer dayLimit
    /**
     * 下发间隔天数
     */
    Integer dayInterval
    /**
     * 当天的间隔，分钟
     * 这是对于一个设备来说的
     */
    Integer timeDelay

    /**
     * 每月下发次数限制
     */
    Integer monthLimit

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
    Integer blockMinTime
    /**
     * 拦截最大秒
     */
    Integer blockMaxTime

    ///////余额信息
    //	String checkMoneyInfo
    /*boolean checkMoney
     String checkMoneyPort
     String checkMoneyInstruction
     String checkMoneyKey
     int checkMoneyThreshold*/


    String checkTarget
    String checkCmd
    String checkReturn
    int checkMoneyThreshold = -1


    static constraints = {
        name blank: false
        operator blank: false
        blockSmsPort nullable: true
        blockKeys nullable: true
        blockNum nullable: true
        blockMinTime nullable: true
        blockMaxTime nullable: true

        wapInfo nullable: true
        instruction nullable: true
        port nullable: true
        checkTarget nullable: true
        checkCmd nullable: true
        checkReturn nullable: true
    }
    static mapping = {
        checkMoneyThreshold defaultValue: -1
        interval column: 'exe_interval'
    }


    public String toString() {
        "canal->id:${id},${this.properties}"
    }
}
