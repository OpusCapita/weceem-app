<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="reqistration"></meta>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'layout.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css', file: 'default.css')}"></link>
    <link rel="stylesheet" href="${createLinkTo(dir: 'css/login', file: 'login.css')}"></link>
    <title>User Registration</title>
  </head>
  <body>
    <div id="header">
      <div id="supplierLogo"></div>
      <div class="title">
        <span id="appName">
          &nbsp;
        </span>
        <span id="userName" title="Current User">
        </span>
      </div>
      <div id="marketLogo"></div>
    </div>

    <div id="stripe"></div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${person}">
      <div class="error">
        <g:renderErrors bean="${person}" as="list"/>
      </div>
    </g:hasErrors>

    <g:form method="POST">

      <table border="0px" cellspacing="0" cellpadding="0" width="100%" height="80%">
        <tr>
          <td style="height: 380px; width: 100%" valign="top">
            <br/>
            <div align="center">
              <b class="header">User Registration</b>
              <br/>

              <table>
                <tbody>
                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Login Name
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'username', 'errors')}'>
                      <input type="text" name='username'
                              value="${person?.username?.encodeAsHTML()}"/>
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
                      <input type="password" name='passwd'
                              value="${person?.passwd?.encodeAsHTML()}"/>
                    </td>
                  </tr>

                  <tr class='prop'>
                    <td valign='top' class='name'>
                      Confirm Password
                    </td>
                    <td valign='top'
                            class='value ${hasErrors(bean: person, field: 'passwd', 'errors')}'>
                      <input type="password" name='repasswd'
                              value="${person?.passwd?.encodeAsHTML()}"/>
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
                    <td valign='bottom' class='name'>
                      Enter Code
                    </td>
                    <td valign='top' class='name'>
                      <input type="text" name="captcha" size="8"/>
                      <img src="${createLink(controller: 'captcha', action: 'index')}" align="absmiddle"/>
                    </td>
                  </tr>

                  <tr>
                    <td colspan="2" align="left">
                      <g:actionSubmit class="button" action="save" value="Create"/>&nbsp;&nbsp;
                      <g:actionSubmit class="button" action="backToLogin" value="Back"/>&nbsp;&nbsp;
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
