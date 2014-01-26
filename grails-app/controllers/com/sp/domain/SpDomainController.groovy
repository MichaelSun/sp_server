package com.sp.domain

import grails.converters.JSON

class SpDomainController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        def list = SpDomain.list()
        def resultList = []
        if (list && !list.empty) {
            list.each {
                if (it.enable) {
                    resultList << it.name
                }
            }
        }
        render([spDomainList: resultList] as JSON)
    }

    def list() {
        index()
    }
}
