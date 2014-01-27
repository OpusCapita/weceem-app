<%@ page import="org.weceem.auth.*" %>

<html>
    <head>
        <meta name="layout" content="weceemadmin"/>
        <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
        <title><g:message code="user.title.edit"/></title>
    </head>
    <body>
        <bean:errorClass>ui-state-error</bean:errorClass>
        <div class="container">
            <g:form controller="CMSUser" action="update" method="POST">
                <g:if test="${CMSUserInstance?.id}">
                    <input type="hidden" name="id" value="${CMSUserInstance?.id}"/>
                </g:if>

                <div class="span-24 last">

                    <h1><g:message code="user.title.edit" encodeAs="HTML"/></h1>

                    <g:render template="fields"/>

                </div>
                <div class="buttons">
                     <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="update"
                        value="${message(code: 'command.save', encodeAs:'HTML')}"/>
                     <g:actionSubmit class="ui-widget ui-state-default ui-corner-all" action="list"
                                     value="${message(code: 'command.cancel', encodeAs:'HTML')}"/>
                </div>
            </g:form>
        </div>
    </body>
</html>
