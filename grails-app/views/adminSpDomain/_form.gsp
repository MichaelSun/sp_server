<%@ page import="com.sp.domain.SpDomain" %>

<div class="fieldcontain ${hasErrors(bean: spDomainInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="spDomain.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${spDomainInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: spDomainInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="spDomain.enable.label" default="Enable" />
		
	</label>
	<g:checkBox name="enable" value="${spDomainInstance?.enable}" />
</div>



