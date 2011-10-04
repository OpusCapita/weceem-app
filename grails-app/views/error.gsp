<%@ page import="grails.util.Metadata" %>
<g:if test="${Metadata.current.getGrailsVersion().startsWith('1.')}">
    <g:render template="/_error_views/grails13errors"/>
</g:if>
<g:else>
    <g:render template="/_error_views/grails2errors"/>
</g:else>