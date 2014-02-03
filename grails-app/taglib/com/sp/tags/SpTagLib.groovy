package com.sp.tags

import java.text.DecimalFormat

class SpTagLib {
    static namespace = "sp"

    def canalType = { attrs, body ->
        out << body() << getType(attrs)
    }

    def canalTypeEn = { attrs, body ->
        out << body() << getEnType(attrs)
    }

    private getType(attrs) {
        if (attrs.type.endsWith('SmsCanal')) {
            "短信通道"
        } else if (attrs.type.endsWith('WapCanal')) {
            "wap通道"
        } else if (attrs.type.endsWith('SdkCanal')) {
            "sdk通道"
        } else {
            printf "taglib canalType missing match type：" + attrs.type
        }
    }

    private getEnType(attrs) {
        def t = attrs.type.replaceAll(".*\\.", "")
        t = "admin" + t
        t
    }

    def getMainCode = { attrs, body ->
        def mainCode = 0
        if (attrs.code) {
            String codeStr = attrs.code as String
            if (codeStr.length() == 6) {
                mainCode = codeStr.substring(0, 3)
            } else if (codeStr.length() == 3) {
                mainCode = codeStr as Integer
            }
        } else {
            mainCode = -1
        }
        out << body() << mainCode
    }

    def rater = { attrs, body ->
        //		if(!attrs.rate){
        //			attrs.rate=100
        //		}
        //		double r=attrs.rate/100
        //		if(!attrs.num){
        //		attrs.num=0
        //		}
        //		out << body() << (attrs.num*r as Integer)
        out << body() << caculateRateNum(attrs.num, attrs.rate)
    }

    def roundRater = { attrs, body ->
        double rateNum = attrs.rateNum
        int ret = Math.round(rateNum)
        if (ret == 0) {
            ret = 1
        }

        out << body() << ret
    }

    def rateFormatStr = { attrs, body ->
        def rate = attrs.rate

        out << body() << (rate as String) + "%"
    }

    def gToSRater = { attrs, body ->
        def activeNum = attrs.num ?: 0
        def godNum = attrs.godItemNum ?: 0

        if (activeNum == 0 || godNum == 0) {
            out << body() << "0.0%"
        } else {
            double rate = (activeNum * 1.0 / godNum) * 100;
            DecimalFormat df = new DecimalFormat(".##");
            String st = df.format(rate);
            out << body() << st + "%"
        }
    }

    def rateListNum = { attrs, body ->

        def result = 0
        attrs.rows.each {

            result += caculateRateNum(it.num, it.rate)
        }


        out << body() << (result)
    }

    private caculateRateNum(num, rate) {
        num = num ?: 0
        rate = rate ?: 100
        double r = rate / 100
        //			result=result+(n*r as Integer)
        Math.round(num * r)
    }

    def canalName = { attrs, body ->

        def ops = ["短信", "WAP", "SDK"]

        out << body() << (ops[(attrs.t as Integer) - 1])
    }


    def opName = { attrs, body ->

        def ops = ["移动", "联通", "电信"]

        out << body() << (ops[(attrs.operator as Integer) - 1])
    }
}
