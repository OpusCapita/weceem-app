<html>
  <head>
    <meta name="description" content="login">
    <meta name="layout" content="login">

    <title><g:message code="title.login"/></title>
    <script type="application/javascript">
     $( function() {
        $('#loginName')[0].focus(); 
     })
    </script>
    <style>
      .text {
          font-family: "Helvetica Neue", Arial, Helvetica, sans-serif;
          font-size: 12px;
      }

    </style>
  </head>
  <body>
    <div class="container" style="margin-top:100px">
      <div class="row">
        <div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3 well">
          <div class="row">
            <img src="${resource(plugin: 'weceem', dir: '_weceem/images/layout', file:'weceem-logo.png')}" style="padding-left: 12px;"/>
          <div>
          <div class="row"  style="margin-top:20px">
            <div class="col-md-12 col-xs-12" >
              <g:if test="${flash.message}">
                  <div class="append-bottom ui-state-highlight">
                      ${flash.message}
                  </div>
              </g:if>
              <form action="${createLinkTo(dir: 'j_spring_security_check')}" method="post" class="form-horizontal" role="form">
                <div class="row">
                  <div class="col-md-5 col-xs-5 text">
                    <label for="loginName" style="padding-left: 12px;"><g:message code="label.userName"/></label>
                  </div>
                  <div class="col-md-7 col-xs-7 text" style="margin-bottom: 4px;">
                    <input type="text" name="j_username" id="loginName"/>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-5 col-xs-5 text">
                    <label for="loginPassword" style="padding-left: 12px;"><g:message code="label.userPassword"/></label>
                  </div>
                  <div class="col-md-7 col-xs-7 text"  style="margin-bottom: 4px;">
                    <input type="password" name="j_password" id="loginPassword"/>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6 col-md-offset-5 col-xs-6 col-xs-offset-5 text">
                    <input type="checkbox" name="_spring_security_remember_me" id="rememberMe">
                    <label for="rememberMe"><g:message code="label.rememberMe"/></label>

                  </div>
                </div>
                <div class="row">
                  <div class=" col-xs-6 col-xs-offset-5 col-md-6 col-md-offset-5 text" style="margin-top: 10px;">
                    <input type="submit" id="loginSubmit" class="btn btn-primary" value="${message(code: 'command.login', encodeAs:'HTML')}"/>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
        </div>
      </div>

      </div>

      <div class="row" style="font-style: italic; position: absolute; bottom: 0; width: 100%; text-align: center;">
        <div class="col-md-12 col-xs-12">
          <span class="text-muted text">v.<g:meta name="app.version"/> - <g:message code="message.footer" encodeAs="HTML"/></span>
        </div>
      </div>

    </div>
     
  </body>
</html>