<%@ page import="org.weceem.auth.*" %>

<html>
    <head>
        <meta name="layout" content="weceemadmin"/>
        <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
        <title><g:message code="user.title.change.password"/></title>
    </head>
    <body>
        <bean:errorClass>ui-state-error</bean:errorClass>
        <div class="container">
            <div class="span-24 last">
                <bean:require beanName="form" className="org.weceem.user.ChangePasswordForm"/>
                <g:form controller="userProfile" action="doChangePassword" method="POST">
                    <input type="hidden" name="id" value="${CMSUserInstance?.id}"/>

                    <h1><g:message code="user.title.change.password" encodeAs="HTML"/></h1>

                    <div class="clear span-4">
                        <bean:label beanName="form" property="current"/>
                    </div>
                    <div class="field prepend-1 span-18 last">
                        <bean:field beanName="form" property="current" type="password" label="${false}"/>
                    </div>
                    
                    <div class="clear span-4">
                        <bean:label beanName="form" property="newPass"/>
                    </div>
                    <div class="field prepend-1 span-18 last">
                        <bean:field beanName="form" property="newPass" type="password" label="${false}"/>
                    </div>
                    <div class="clear span-4">
                        <bean:label beanName="form" property="confirmPass"/>
                    </div>
                    <div class="field prepend-1 span-18 last">
                        <bean:field beanName="form" property="confirmPass" type="password" label="${false}"/>
                    </div>

                    <div class="buttons">
                        <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="edit"
                            value="${message(code: 'command.cancel', encodeAs:'HTML')}"/>
                        <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="doChangePassword"
                            value="${message(code: 'command.save', encodeAs:'HTML')}"/>
                    </div>
                </g:form>

            </div>
        </div>
    </body>
</html>
