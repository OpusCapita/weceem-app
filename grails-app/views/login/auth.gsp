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

  </head>
  <body>
    <div class="container" style="margin-top:200px">
        <div class="prepend-8 span-8 append-8 last">
            <div class="container span-8 last box ui-corner-all">
                <div class="span-8 append-bottom last">
                    <img src="${resource(plugin: 'weceem', dir: '_weceem/images/layout', file:'weceem-logo.png')}"/>
                </div>

                <div class="span-8 prepend-top last">
                    <g:if test="${flash.message}">
                         <div class="append-bottom ui-state-highlight">
                               ${flash.message}
                         </div>
                    </g:if>

                    <form action="${createLinkTo(dir: 'j_spring_security_check')}" method="post">
                        <div class="span-3">
                            <label for="loginName"><g:message code="label.userName"/></label>
                        </div>
                        <div class="span-5 last">
                            <input type="text" name="j_username" id="loginName"/>
                        </div>

                        <div class="span-3">
                            <label for="loginPassword"><g:message code="label.userPassword"/></label>
                        </div>
                        <div class="span-5 last">
                            <input type="password" name="j_password" id="loginPassword"/>
                        </div>

                        <div class="prepend-3 span-5 last">
                            <input type="checkbox" name="_spring_security_remember_me" id="rememberMe"><label for="rememberMe"><g:message code="label.rememberMe"/></label>
                        </div>
                
                        <div class="prepend-3 prepend-top span-5 last">
                            <input type="submit" id="loginSubmit" class="button ui-corner-all ui-state-default ui-priority-primary ui-widget" value="${message(code: 'command.login', encodeAs:'HTML')}"/>
                        </div>
                
                        <div class="prepend-3 prepend-top span-5 last">
                            <g:message code="login.login.notMember"/>
                            <g:link controller="userProfile" action="register"><g:message code="login.login.signup"/></g:link>
                        </div>
                    </form>
                </div>
            </div>
            <div class="container span-9 alt last" style="text-align: right">
                v.<g:meta name="app.version"/> - <g:message code="message.footer" encodeAs="HTML"/>
            </div>
        </div>
    </div>
     
  </body>
</html>