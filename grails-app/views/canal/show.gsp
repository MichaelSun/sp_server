
<%@ page import="com.sp.domain.Canal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'canal.label', default: 'Canal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-canal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-canal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list canal">
			
				<g:if test="${canalInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="canal.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${canalInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="canal.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${canalInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.enable}">
				<li class="fieldcontain">
					<span id="enable-label" class="property-label"><g:message code="canal.enable.label" default="Enable" /></span>
					
						<span class="property-value" aria-labelledby="enable-label"><g:formatBoolean boolean="${canalInstance?.enable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.exeEnd}">
				<li class="fieldcontain">
					<span id="exeEnd-label" class="property-label"><g:message code="canal.exeEnd.label" default="Exe End" /></span>
					
						<span class="property-value" aria-labelledby="exeEnd-label"><g:fieldValue bean="${canalInstance}" field="exeEnd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.exeStart}">
				<li class="fieldcontain">
					<span id="exeStart-label" class="property-label"><g:message code="canal.exeStart.label" default="Exe Start" /></span>
					
						<span class="property-value" aria-labelledby="exeStart-label"><g:fieldValue bean="${canalInstance}" field="exeStart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.interval}">
				<li class="fieldcontain">
					<span id="interval-label" class="property-label"><g:message code="canal.interval.label" default="Interval" /></span>
					
						<span class="property-value" aria-labelledby="interval-label"><g:fieldValue bean="${canalInstance}" field="interval"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="canal.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${canalInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="canal.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${canalInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.operator}">
				<li class="fieldcontain">
					<span id="operator-label" class="property-label"><g:message code="canal.operator.label" default="Operator" /></span>
					
						<span class="property-value" aria-labelledby="operator-label"><g:fieldValue bean="${canalInstance}" field="operator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.province}">
				<li class="fieldcontain">
					<span id="province-label" class="property-label"><g:message code="canal.province.label" default="Province" /></span>
					
						<span class="property-value" aria-labelledby="province-label"><g:fieldValue bean="${canalInstance}" field="province"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${canalInstance?.times}">
				<li class="fieldcontain">
					<span id="times-label" class="property-label"><g:message code="canal.times.label" default="Times" /></span>
					
						<span class="property-value" aria-labelledby="times-label"><g:fieldValue bean="${canalInstance}" field="times"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${canalInstance?.id}" />
					<g:link class="edit" action="edit" id="${canalInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
