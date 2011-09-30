package org.weceem.user

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class ChangePasswordForm {
    String current
    String newPass
    String confirmPass
    
    static constraints = {
        current(maxSize:30, nullable: false)
        newPass(maxSize:30, nullable: false)
        confirmPass(maxSize:30, nullable: false, validator: { val, obj -> 
            obj.newPass == val ? null : 'user.new.password.does.not.match'
        })
    }
}