<g:each in="['username', 'firstName', 'lastName', 'email']" var="prop">
    <div class="row">
      <div class="col-md-2 col-xs-2">
        <bean:label beanName="CMSUserInstance" property="${prop}"/>
      </div>
      <div class="col-md-10 col-xs-10">
        <bean:field beanName="CMSUserInstance" property="${prop}" label="${false}"/>
      </div>
    </div>
</g:each>

