<html>
  <head>
    <meta name="layout" content="weceemadmin"/>
    <title><g:message code="user.title.list"/></title>
  </head>
  <body>
    <nav:set path="plugin.weceem.weceem_menu/administration" scope="plugin.weceem.weceem_menu"/>
    <div class="container">
      <div class="row">
        <div class="col-md-12 col-xs-12">
          <h1><g:message code="user.title.list" encodeAs="HTML"/></h1>
        </div>
      </div>

      <g:form controller="CMSUser" action="create">
        <div class="row" style="margin-bottom: 2px;">
          <div class="col-md-12 col-xs-12">
            <g:actionSubmit action="create" value="${message(code: 'command.add')}" class="button"/>
          </div>
        </div>
      </g:form>

      <div class="row">
        <div class="col-md-12 col-xs-12">
        <table class="standard">
          <thead>
            <tr>
              <g:sortableColumn property="username" title="${message(code: 'user.header.username')}"/>
              <g:sortableColumn property="firstName" title="${message(code: 'user.header.firstName')}"/>
              <g:sortableColumn property="lastName" title="${message(code: 'user.header.lastName')}"/>
              <th>${message(code: 'user.header.roles')}</th>
              <g:sortableColumn property="enabled" title="${message(code: 'user.header.enabled')}"/>
              <th>${message(code: 'user.header.actions')}</th>
            </tr>
          </thead>
          <tbody>
            <g:each in="${CMSUserInstanceList}" status="i" var="user">
              <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                <td>${user.username?.encodeAsHTML()}</td>
                <td>${user.firstName?.encodeAsHTML()}</td>
                <td>${user.lastName?.encodeAsHTML()}</td>
                <td>${user.roleAuthorities.join(', ').encodeAsHTML()}</td>
                <td>${user.enabled ? 'Yes' : 'No'}</td>
                <td>
                  <g:link action="edit" id="${user.id}" class="button"><g:message code="command.edit" encodeAs="HTML"/></g:link>
                  <g:link action="delete" id="${user.id}" class="button" onclick="return confirm('Are you sure you want to delete [${user.username.encodeAsJavaScript()}]?');"><g:message code="command.delete" encodeAs="HTML"/></g:link>
                </td>
              </tr>
            </g:each>
          </tbody>
        </table>
        <div class="paginateButtons">
          <g:paginate total="${org.weceem.auth.CMSUser.count()}"/>
        </div>
        </div>
      </div>

    </div>
  </body>
</html>
