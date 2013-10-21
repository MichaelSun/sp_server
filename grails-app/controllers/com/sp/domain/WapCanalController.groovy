package com.sp.domain

import org.springframework.dao.DataIntegrityViolationException

class WapCanalController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [wapCanalInstanceList: WapCanal.list(params), wapCanalInstanceTotal: WapCanal.count()]
    }

    def create() {
        [wapCanalInstance: new WapCanal(params)]
    }

    def save() {
        def wapCanalInstance = new WapCanal(params)
        if (!wapCanalInstance.save(flush: true)) {
            render(view: "create", model: [wapCanalInstance: wapCanalInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), wapCanalInstance.id])
        redirect(action: "show", id: wapCanalInstance.id)
    }

    def show(Long id) {
        def wapCanalInstance = WapCanal.get(id)
        if (!wapCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "list")
            return
        }

        [wapCanalInstance: wapCanalInstance]
    }

    def edit(Long id) {
        def wapCanalInstance = WapCanal.get(id)
        if (!wapCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "list")
            return
        }

        [wapCanalInstance: wapCanalInstance]
    }

    def update(Long id, Long version) {
        def wapCanalInstance = WapCanal.get(id)
        if (!wapCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (wapCanalInstance.version > version) {
                wapCanalInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'wapCanal.label', default: 'WapCanal')] as Object[],
                          "Another user has updated this WapCanal while you were editing")
                render(view: "edit", model: [wapCanalInstance: wapCanalInstance])
                return
            }
        }

        wapCanalInstance.properties = params

        if (!wapCanalInstance.save(flush: true)) {
            render(view: "edit", model: [wapCanalInstance: wapCanalInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), wapCanalInstance.id])
        redirect(action: "show", id: wapCanalInstance.id)
    }

    def delete(Long id) {
        def wapCanalInstance = WapCanal.get(id)
        if (!wapCanalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "list")
            return
        }

        try {
            wapCanalInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'wapCanal.label', default: 'WapCanal'), id])
            redirect(action: "show", id: id)
        }
    }
}
