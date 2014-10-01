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
          <!--ui-state-error -->
        </div>
      </div>

      <g:set var="form" value="${new org.weceem.user.ChangePasswordForm()}"/>

      <g:form controller="userProfile" action="doChangePassword" method="POST">
      <input type="hidden" name="id" value="${CMSUserInstance?.id}"/>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <h1><g:message code="user.title.change.password" encodeAs="HTML"/></h1>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <f:field bean="form" property="current">
            <g:passwordField name="current" value="${form.current}"/>
          </f:field>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <f:field bean="form" property="newPass">
              <g:passwordField name="current" value="${form.newPass}"/>
          </f:field>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 col-xs-12">
          <f:field bean="form" property="confirmPass">
             <g:passwordField name="current" value="${form.confirmPass}"/>
          </f:field>
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
