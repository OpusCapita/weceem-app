<g:each in="['username', 'firstName', 'lastName', 'email']" var="prop">
    <div class="row">
      <div class="col-md-12 col-xs-12">
        <f:field bean="CMSUserInstance" property="${prop}"/>
      </div>
    </div>
</g:each>

