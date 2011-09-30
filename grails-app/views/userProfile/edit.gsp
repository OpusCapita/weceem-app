<%@ page import="org.weceem.auth.*" %>

<html>
    <head>
        <meta name="layout" content="weceemadmin"/>
        <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
        <title><g:message code="user.title.profile"/></title>
    </head>
    <body>
        <bean:errorClass>ui-state-error</bean:errorClass>
        <div class="container">
            <div class="span-18">

                <g:form controller="userProfile" action="update" method="POST">
                    <input type="hidden" name="id" value="${CMSUserInstance?.id}"/>
                    <input type="hidden" name="returnURL" value="${returnURL}"/>

                    <h1><g:message code="user.title.profile" encodeAs="HTML"/></h1>

                    <g:render template="profilefields"/>

                    <div class="buttons">
                        <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="back"
                            value="${message(code: 'command.back', encodeAs:'HTML')}"/>
                        <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="update"
                            value="${message(code: 'command.save', encodeAs:'HTML')}"/>
                    </div>
                </g:form>

            </div>
        
            <div class="span-6 last">
                
                <h2>Your content</h2>
                <ul>
                <g:each in="${recentContent}" var="c">
                    <li><g:link controller="wcmEditor" action="edit" id="${c.id}">${c.title.encodeAsHTML()}</g:link>
                </g:each>
                </ul>

                <g:link action="changePassword">Change your password</g:link>
            </div>
        </div>
    </body>
</html>
