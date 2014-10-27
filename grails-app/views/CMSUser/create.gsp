<%@ page import="org.weceem.auth.*" %>

<html>
  <head>
      <meta name="layout" content="weceemadmin"/>
      <link rel="stylesheet" href="${g.resource(dir:'_weceem/css', file:'admin.css').encodeAsHTML()}"/>
      <title><g:message code="user.title.create"/></title>
  </head>
  <body>
    <nav:set path="plugin.weceem.weceem_menu/administration" scope="plugin.weceem.weceem_menu"/>
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-xs-12">
          <!--ui-state-error -->
        </div>
      </div>

      <g:form controller="CMSUser" action="save" method="POST">
        <div class="row">
          <div class="col-md-12 col-xs-12">
            <h1><g:message code="user.title.create" encodeAs="HTML"/></h1>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12 col-xs-12">
            <g:render template="fields"/>
          </div>
        </div>

        <div class="row">
          <div class="col-md-12 col-xs-12">
            <g:actionSubmit action="save"
                value="${message(code: 'command.save', encodeAs:'HTML')}" class="button"/>
            <g:link action="list" controller="${params.controller}" style="color: black; text-decoration: none;">
               <input type="button" value="${message(code:'content.button.cancel', default:'Cancel')}" class="button"/>
            </g:link>
          </div>
        </div>
      </g:form>
    </div>
  </body>
</html>
