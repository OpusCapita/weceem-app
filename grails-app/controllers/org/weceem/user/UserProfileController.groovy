package org.weceem.user

import org.weceem.content.WcmContent
import org.weceem.auth.CMSUser

class UserProfileController {
    static defaultAction = 'edit'
    
    def springSecurityService
    
    def edit = {
        def user = CMSUser.get(springSecurityService.principal.id)
        def recentContent = WcmContent.findAllByCreatedBy(user.username, [max:10, sort:'changedOn', order:'DESC'])
        [CMSUserInstance:user, recentContent: recentContent]
    }
    
    def back = {
        redirect(uri:params.returnURL)
    }
    
    def update = {
        def user = CMSUser.get(springSecurityService.principal.id)

        // @todo Bind only user-editable stuff e.g. password and details, not username or authorities/enabled
        user.properties = params
    }
    
    def changePassword = {
    }

    def doChangePassword = { ChangePasswordForm form ->
        if (!form.hasErrors()) {
            assert form.newPass == form.confirmPass // Double double safety check!
            
            def user = CMSUser.get(springSecurityService.principal.id)
            if (springSecurityService.encodePassword(form.current) == user.passwd) {
                user.pass = form.newPass
                user.save(flush:true) // User needs to know if this will fail
                flash.message = 'user.password.changed'
                redirect(action:'edit')
            } else {
                flash.message = 'user.current.password.incorrect'
                render(view:'changePassword', model:[form:form])
            }
        } else {
            render(view:'changePassword', model:[form:form])
        }
    }
}
