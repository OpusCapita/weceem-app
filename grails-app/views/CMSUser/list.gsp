<html>
  <head>
    <meta name="layout" content="weceemadmin"/>
    <title><g:message code="user.title.list"/></title>
  </head>
  <body>
    <div class="body">
      <h1><g:message code="user.title.list" encodeAs="HTML"/></h1>

      <g:form controller="CMSUser" action="create">
        <div class="nav">
            <g:actionSubmit action="create" value="${message(code: 'command.add')}" class="ui-widget ui-state-default ui-corner-all"/>
        </div>
      </g:form>

      <div class="list">
        <table class="standard">
          <thead>
            <tr>
              <g:sortableColumn property="username" title="${message(code: 'user.header.username')}"/>
              <g:sortableColumn property="firstName" title="${message(code: 'user.header.firstName')}"/>
              <g:sortableColumn property="lastName" title="${message(code: 'user.header.lastName')}"/>
              <th>${message(code: 'user.header.roles')}</th>
              <g:sortableColumn property="enabled" title="${message(code: 'user.header.enabled')}"/>
              <th><g:message code="user.header.actions"/></th> 
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
                  <g:link action="edit" id="${user.id}" class="button ui-corner-all"><g:message code="command.edit" encodeAs="HTML"/></g:link>
                  <g:link action="delete" id="${user.id}" class="button ui-corner-all" onclick="return confirm('Are you sure you want to delete [${user.username.encodeAsJavaScript()}]?');"><g:message code="command.delete" encodeAs="HTML"/></g:link>
                </td>
              </tr>
            </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${org.weceem.auth.CMSUser.count()}"/>
      </div>
    </div>
  </body>
</html>
