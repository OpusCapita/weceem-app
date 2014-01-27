<%@ page import="org.weceem.auth.*" %>

<html>
    <head>
        <meta name="layout" content="weceemadmin"/>
        <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
        <title><g:message code="user.title.create"/></title>
    </head>
    <body>
        <bean:errorClass>ui-state-error</bean:errorClass>
        <div class="container">
            <g:form controller="CMSUser" action="save" method="POST">

                <div class="span-24 last">

                    <h1><g:message code="user.title.create" encodeAs="HTML"/></h1>

                    <g:render template="fields"/>
                </div>

                <div class="buttons">
                    <g:actionSubmit action="save"
                        value="${message(code: 'command.save', encodeAs:'HTML')}" class="ui-widget ui-state-default ui-corner-all"/>
                    <g:actionSubmit action="list"
                                    value="${message(code: 'command.cancel', encodeAs:'HTML')}" class="ui-widget ui-state-default ui-corner-all"/>
                </div>
            </g:form>
        </div>
    </body>
</html>
