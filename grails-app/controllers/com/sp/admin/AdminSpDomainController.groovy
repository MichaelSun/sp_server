package com.sp.admin

import org.springframework.dao.DataIntegrityViolationException

import com.sp.domain.SpDomain

class AdminSpDomainController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [spDomainInstanceList: SpDomain.list(params), spDomainInstanceTotal: SpDomain.count()]
    }

    def create() {
        [spDomainInstance: new SpDomain(params)]
    }

    def save() {
        def spDomainInstance = new SpDomain(params)
        if (!spDomainInstance.save(flush: true)) {
            render(view: "create", model: [spDomainInstance: spDomainInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), spDomainInstance.id])
        redirect(action: "show", id: spDomainInstance.id)
    }

    def show(Long id) {
        def spDomainInstance = SpDomain.get(id)
        if (!spDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "list")
            return
        }

        [spDomainInstance: spDomainInstance]
    }

    def edit(Long id) {
        def spDomainInstance = SpDomain.get(id)
        if (!spDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "list")
            return
        }

        [spDomainInstance: spDomainInstance]
    }

    def update(Long id, Long version) {
        def spDomainInstance = SpDomain.get(id)
        if (!spDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (spDomainInstance.version > version) {
                spDomainInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'spDomain.label', default: 'SpDomain')] as Object[],
                          "Another user has updated this SpDomain while you were editing")
                render(view: "edit", model: [spDomainInstance: spDomainInstance])
                return
            }
        }

        spDomainInstance.properties = params

        if (!spDomainInstance.save(flush: true)) {
            render(view: "edit", model: [spDomainInstance: spDomainInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), spDomainInstance.id])
        redirect(action: "show", id: spDomainInstance.id)
    }

    def delete(Long id) {
        def spDomainInstance = SpDomain.get(id)
        if (!spDomainInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "list")
            return
        }

        try {
            spDomainInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'spDomain.label', default: 'SpDomain'), id])
            redirect(action: "show", id: id)
        }
    }
}
