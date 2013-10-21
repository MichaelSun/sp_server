package com.sp.domain

import org.springframework.dao.DataIntegrityViolationException

class CanalController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [canalInstanceList: Canal.list(params), canalInstanceTotal: Canal.count()]
    }

    def create() {
        [canalInstance: new Canal(params)]
    }

    def save() {
        def canalInstance = new Canal(params)
        if (!canalInstance.save(flush: true)) {
            render(view: "create", model: [canalInstance: canalInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'canal.label', default: 'Canal'), canalInstance.id])
        redirect(action: "show", id: canalInstance.id)
    }

    def show(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "list")
            return
        }

        [canalInstance: canalInstance]
    }

    def edit(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "list")
            return
        }

        [canalInstance: canalInstance]
    }

    def update(Long id, Long version) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (canalInstance.version > version) {
                canalInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'canal.label', default: 'Canal')] as Object[],
                          "Another user has updated this Canal while you were editing")
                render(view: "edit", model: [canalInstance: canalInstance])
                return
            }
        }

        canalInstance.properties = params

        if (!canalInstance.save(flush: true)) {
            render(view: "edit", model: [canalInstance: canalInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'canal.label', default: 'Canal'), canalInstance.id])
        redirect(action: "show", id: canalInstance.id)
    }

    def delete(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "list")
            return
        }

        try {
            canalInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'canal.label', default: 'Canal'), id])
            redirect(action: "show", id: id)
        }
    }
}
