    <g:render template="/userProfile/profilefields"/>

    <div class="clear span-4">
        <g:if test="${actionName in ['edit', 'update']}">
            <bean:label beanName="CMSUserInstance" property="pass" required=" "/>
        </g:if>
        <g:else>
            <bean:label beanName="CMSUserInstance" property="pass"/>
        </g:else>
    </div>
    <div class="field prepend-1 span-18 last">
        <bean:field beanName="CMSUserInstance" property="pass" type="password" valueOverride="${passwordNonce}" label="${false}"/>
    </div>

    <div class="clear span-4">
        <bean:label beanName="CMSUserInstance" property="enabled"/>
    </div>
    <div class="field prepend-1 span-18 last">
        <bean:field beanName="CMSUserInstance" property="enabled" label="${false}"/>
    </div>

    <div class="clear span-4">
        <label for="authorities"><g:message code="user.label.authorities"/></label>
    </div>
    <div id="roles" class="field prepend-1 span-18 last">
        <g:checkBoxList name="roleIds" from="${org.weceem.auth.CMSRole.list()}" value="${CMSUserInstance?.authorities?.collect{it.id}}" optionKey="id" optionValue="authority"/>
    </div>

