package com.sp.domain

import org.springframework.dao.DataIntegrityViolationException

class SmsCanalController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [smsCanalInstanceList: SmsCanal.list(params), smsCanalInstanceTotal: SmsCanal.count()]
    }

    def create() {
        [smsCanalInstance: new SmsCanal(params)]
    }

    def save() {
        def smsCanalInstance = new SmsCanal(params)
        if (!smsCanalInstance.save(flush: true)) {
            render(view: "create", model: [smsCanalInstance: smsCanalInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), smsCanalInstance.id])
        redirect(action: "show", id: smsCanalInstance.id)
    }

    def show(Long id) {
        def smsCanalInstance = SmsCanal.get(id)
        if (!smsCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "list")
            return
        }

        [smsCanalInstance: smsCanalInstance]
    }

    def edit(Long id) {
        def smsCanalInstance = SmsCanal.get(id)
        if (!smsCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "list")
            return
        }

        [smsCanalInstance: smsCanalInstance]
    }

    def update(Long id, Long version) {
        def smsCanalInstance = SmsCanal.get(id)
        if (!smsCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (smsCanalInstance.version > version) {
                smsCanalInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'smsCanal.label', default: 'SmsCanal')] as Object[],
                          "Another user has updated this SmsCanal while you were editing")
                render(view: "edit", model: [smsCanalInstance: smsCanalInstance])
                return
            }
        }

        smsCanalInstance.properties = params

        if (!smsCanalInstance.save(flush: true)) {
            render(view: "edit", model: [smsCanalInstance: smsCanalInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), smsCanalInstance.id])
        redirect(action: "show", id: smsCanalInstance.id)
    }

    def delete(Long id) {
        def smsCanalInstance = SmsCanal.get(id)
        if (!smsCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "list")
            return
        }

        try {
            smsCanalInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'smsCanal.label', default: 'SmsCanal'), id])
            redirect(action: "show", id: id)
        }
    }
}
