    <g:render template="/userProfile/profilefields"/>

    <div class="row">
      <div class="col-md-2 col-xs-2">
        <g:if test="${actionName in ['edit', 'update']}">
            <bean:label beanName="CMSUserInstance" property="pass" required=" "/>
        </g:if>
        <g:else>
            <bean:label beanName="CMSUserInstance" property="pass"/>
        </g:else>
      </div>
      <div class="col-md-10 col-xs-10">
        <bean:field beanName="CMSUserInstance" property="pass" type="password" valueOverride="${passwordNonce}" label="${false}"/>
      </div>
    </div>

    <div class="row">
      <div class="col-md-2 col-xs-2">
        <bean:label beanName="CMSUserInstance" property="enabled"/>
      </div>
      <div class="col-md-10 col-xs-10">
        <bean:field beanName="CMSUserInstance" property="enabled" label="${false}"/>
      </div>
    </div>

    <div class="row">
      <div class="col-md-2 col-xs-2">
        <label for="authorities"><g:message code="user.label.authorities"/></label>
      </div>
      <div id="roles" class="col-md-10 col-xs-10">
        <g:checkBoxList name="roleIds" from="${org.weceem.auth.CMSRole.list()}" value="${CMSUserInstance?.authorities?.collect{it.id}}" optionKey="id" optionValue="authority"/>
      </div>
    </div>

