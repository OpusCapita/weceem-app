package org.weceem.auth

class CMSUserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        println "${grailsApplication.mainContext.userDetailsService}"
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [CMSUserInstanceList: CMSUser.list(params), CMSUserInstanceTotal: CMSUser.count()]
    }

    def create = {
        def CMSUserInstance = new CMSUser()
        CMSUserInstance.properties = params
        return [CMSUserInstance: CMSUserInstance]
    }

    def save = {
        def CMSUserInstance = new CMSUser(params)
        if (CMSUserInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), CMSUserInstance.id])}"
            redirect(action: "list", id: CMSUserInstance.id)
        }
        else {
            log.error "Errors when saving user: ${CMSUserInstance.errors}"
            render(view: "create", model: [CMSUserInstance: CMSUserInstance])
        }
    }

    def show = {
        def CMSUserInstance = CMSUser.get(params.id)
        if (!CMSUserInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
            redirect(action: "list")
        }
        else {
            [CMSUserInstance: CMSUserInstance]
        }
    }

    def edit = {
        def CMSUserInstance = CMSUser.get(params.id)
        if (!CMSUserInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [CMSUserInstance: CMSUserInstance, passwordNonce: '@@pass@@'+System.currentTimeMillis()]
        }
    }

    def update = {
        def CMSUserInstance = CMSUser.get(params.id)
        if (CMSUserInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (CMSUserInstance.version > version) {
                    
                    CMSUserInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'CMSUser.label', default: 'CMSUser')] as Object[], "Another user has updated this CMSUser while you were editing")
                    render(view: "edit", model: [CMSUserInstance: CMSUserInstance])
                    return
                }
            }
            
            // Remove password if it hasn't changed
            if (params.pass == params.passwordNonce) {
                params.remove('pass')
            }
            
            CMSUserInstance.properties = params

            if (!CMSUserInstance.hasErrors() && CMSUserInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), CMSUserInstance.id])}"
                redirect(action: "list", id: CMSUserInstance.id)
            }
            else {
                render(view: "edit", model: [CMSUserInstance: CMSUserInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def CMSUserInstance = CMSUser.get(params.id)
        if (CMSUserInstance) {
            try {
                CMSUserInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
                redirect(action: "list", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'CMSUser.label', default: 'CMSUser'), params.id])}"
            redirect(action: "list")
        }
    }
}
