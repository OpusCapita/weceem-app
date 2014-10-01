    <g:render template="/userProfile/profilefields"/>

    <div class="row">
      <div class="col-md-12 col-xs-12">
        <f:field bean="CMSUserInstance" property="pass">
          <g:passwordField name="pass" value="${CMSUserInstance.pass}"/>
        </f:field>
        <!--f:field beanName="CMSUserInstance" property="pass" type="password" valueOverride="${passwordNonce}" label="${false}"/-->
      </div>

    </div>

    <div class="row">
      <div class="col-md-12 col-xs-12">
        <f:field bean="CMSUserInstance" property="enabled"/>
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

