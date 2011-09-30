<html>
  <head>
    <meta name="layout" content="admin"/>
    <meta name="description" content="profile"></meta>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'layout.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'default.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css/login', file: 'login.css')}"></link>
    <title>Edit Profile</title>
  </head>

  <body>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${person}">
      <div class="error">
        <g:renderErrors bean="${person}" as="list"/>
      </div>
    </g:hasErrors>

    <g:form controller="register" method="POST" action="update">

      <table border="0px" cellspacing="0" cellpadding="0" width="100%" height="80%">
        <tr>
          <td style="height: 380px; width: 100%" valign="top">
            <br/>
            <div align="center">
              <b class="header">Edit Profile</b>
              <br/>

              <table>
                <tbody>
                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Login Name
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'username', 'errors')}'>
                      <input type="hidden" name='username'
                              value="${person?.username?.encodeAsHTML()}"/>
                      <div style="margin:3px">${person?.username?.encodeAsHTML()}</div>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      First Name
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'firstName', 'errors')}'>
                      <input type="text" name='firstName'
                              value="${person?.firstName?.encodeAsHTML()}"/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Last Name
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'lastName', 'errors')}'>
                      <input type="text" name='lastName'
                              value="${person?.lastName?.encodeAsHTML()}"/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Password
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'passwd', 'errors')}'>
                      <input type="password" name='passwd' value=""/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Confirm Password
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'passwd', 'errors')}'>
                      <input type="password" name='repasswd'
                              value=""/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Email
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'email', 'errors')}'>
                      <input type="text" name='email'
                              value="${person?.email?.encodeAsHTML()}"/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Show Email
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'emailShow', 'errors')}'>
                      <g:checkBox name='emailShow' value="${person?.emailShow}"></g:checkBox>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="2" align="left">
                      <g:actionSubmit class="button" action="update" value="Save"/>&nbsp;&nbsp;
                      <g:actionSubmit class="button" action="back" value="Back"/>&nbsp;&nbsp;
                    </td>
                  </tr>

                </tbody>
              </table>
            </div>
          </td>
        </tr>
      </table>

    </g:form>

  </body>
</html>
