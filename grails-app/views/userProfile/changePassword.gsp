<%@ page import="org.weceem.auth.*" %>

<html>
  <head>
        <meta name="layout" content="weceemadmin"/>
        <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
        <title><g:message code="user.title.change.password"/></title>
  </head>
  <body>

    <div class="container">
      <div class="row">
        <div class="col-md-12 col-xs-12">
          <bean:errorClass>ui-state-error</bean:errorClass>
        </div>
      </div>

      <bean:require beanName="form" className="org.weceem.user.ChangePasswordForm"/>
      <g:form controller="userProfile" action="doChangePassword" method="POST">
      <input type="hidden" name="id" value="${CMSUserInstance?.id}"/>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <h1><g:message code="user.title.change.password" encodeAs="HTML"/></h1>
        </div>
      </div>

      <div class="row">
        <div class="col-md-2 col-xs-2">
          <bean:label beanName="form" property="current"/>
        </div>
        <div class="col-md-10 col-xs-10">
          <bean:field beanName="form" property="current" type="password" label="${false}"/>
        </div>
      </div>

      <div class="row">
        <div class="col-md-2 col-xs-2">
          <bean:label beanName="form" property="newPass"/>
        </div>
        <div class="col-md-10 col-xs-10">
          <bean:field beanName="form" property="newPass" type="password" label="${false}"/>
        </div>
      </div>

      <div class="row">
        <div class="col-md-2 col-xs-2">
          <bean:label beanName="form" property="confirmPass"/>
        </div>
        <div class="col-md-10 col-xs-10">
          <bean:field beanName="form" property="confirmPass" type="password" label="${false}"/>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <g:actionSubmit class="button" action="doChangePassword"
                            value="${message(code: 'command.save', encodeAs:'HTML')}"/>
          <g:actionSubmit class="button" action="edit"
               value="${message(code: 'command.cancel', encodeAs:'HTML')}"/>
        </div>
      </div>
      </g:form>
    </div>
  </body>
</html>
