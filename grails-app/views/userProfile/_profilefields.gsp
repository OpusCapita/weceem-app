<g:each in="['username', 'firstName', 'lastName', 'email']" var="prop">
        <div class="clear span-4">
            <bean:label beanName="CMSUserInstance" property="${prop}"/>
        </div>
        <div class="field prepend-1 span-13 last">
            <bean:field beanName="CMSUserInstance" property="${prop}" label="${false}"/>
        </div>
</g:each>

