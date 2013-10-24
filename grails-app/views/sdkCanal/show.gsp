
<%@ page import="com.sp.domain.SdkCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sdkCanal.label', default: 'SdkCanal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sdkCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sdkCanal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sdkCanal">
			
				<g:if test="${sdkCanalInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="sdkCanal.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${sdkCanalInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.operator}">
				<li class="fieldcontain">
					<span id="operator-label" class="property-label"><g:message code="sdkCanal.operator.label" default="Operator" /></span>
					
						<span class="property-value" aria-labelledby="operator-label"><g:fieldValue bean="${sdkCanalInstance}" field="operator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.area}">
				<li class="fieldcontain">
					<span id="area-label" class="property-label"><g:message code="sdkCanal.area.label" default="Area" /></span>
					
						<span class="property-value" aria-labelledby="area-label"><g:fieldValue bean="${sdkCanalInstance}" field="area"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.blockKeys}">
				<li class="fieldcontain">
					<span id="blockKeys-label" class="property-label"><g:message code="sdkCanal.blockKeys.label" default="Block Keys" /></span>
					
						<span class="property-value" aria-labelledby="blockKeys-label"><g:fieldValue bean="${sdkCanalInstance}" field="blockKeys"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.blockMaxTime}">
				<li class="fieldcontain">
					<span id="blockMaxTime-label" class="property-label"><g:message code="sdkCanal.blockMaxTime.label" default="Block Max Time" /></span>
					
						<span class="property-value" aria-labelledby="blockMaxTime-label"><g:fieldValue bean="${sdkCanalInstance}" field="blockMaxTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.blockMinTime}">
				<li class="fieldcontain">
					<span id="blockMinTime-label" class="property-label"><g:message code="sdkCanal.blockMinTime.label" default="Block Min Time" /></span>
					
						<span class="property-value" aria-labelledby="blockMinTime-label"><g:fieldValue bean="${sdkCanalInstance}" field="blockMinTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.blockNum}">
				<li class="fieldcontain">
					<span id="blockNum-label" class="property-label"><g:message code="sdkCanal.blockNum.label" default="Block Num" /></span>
					
						<span class="property-value" aria-labelledby="blockNum-label"><g:fieldValue bean="${sdkCanalInstance}" field="blockNum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="sdkCanal.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${sdkCanalInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.dayInterval}">
				<li class="fieldcontain">
					<span id="dayInterval-label" class="property-label"><g:message code="sdkCanal.dayInterval.label" default="Day Interval" /></span>
					
						<span class="property-value" aria-labelledby="dayInterval-label"><g:fieldValue bean="${sdkCanalInstance}" field="dayInterval"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.dayLimit}">
				<li class="fieldcontain">
					<span id="dayLimit-label" class="property-label"><g:message code="sdkCanal.dayLimit.label" default="Day Limit" /></span>
					
						<span class="property-value" aria-labelledby="dayLimit-label"><g:fieldValue bean="${sdkCanalInstance}" field="dayLimit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.enable}">
				<li class="fieldcontain">
					<span id="enable-label" class="property-label"><g:message code="sdkCanal.enable.label" default="Enable" /></span>
					
						<span class="property-value" aria-labelledby="enable-label"><g:formatBoolean boolean="${sdkCanalInstance?.enable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.exeEnd}">
				<li class="fieldcontain">
					<span id="exeEnd-label" class="property-label"><g:message code="sdkCanal.exeEnd.label" default="Exe End" /></span>
					
						<span class="property-value" aria-labelledby="exeEnd-label"><g:fieldValue bean="${sdkCanalInstance}" field="exeEnd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.exeStart}">
				<li class="fieldcontain">
					<span id="exeStart-label" class="property-label"><g:message code="sdkCanal.exeStart.label" default="Exe Start" /></span>
					
						<span class="property-value" aria-labelledby="exeStart-label"><g:fieldValue bean="${sdkCanalInstance}" field="exeStart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.interval}">
				<li class="fieldcontain">
					<span id="interval-label" class="property-label"><g:message code="sdkCanal.interval.label" default="Interval" /></span>
					
						<span class="property-value" aria-labelledby="interval-label"><g:fieldValue bean="${sdkCanalInstance}" field="interval"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="sdkCanal.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${sdkCanalInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.monthLimit}">
				<li class="fieldcontain">
					<span id="monthLimit-label" class="property-label"><g:message code="sdkCanal.monthLimit.label" default="Month Limit" /></span>
					
						<span class="property-value" aria-labelledby="monthLimit-label"><g:fieldValue bean="${sdkCanalInstance}" field="monthLimit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sdkCanalInstance?.times}">
				<li class="fieldcontain">
					<span id="times-label" class="property-label"><g:message code="sdkCanal.times.label" default="Times" /></span>
					
						<span class="property-value" aria-labelledby="times-label"><g:fieldValue bean="${sdkCanalInstance}" field="times"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${sdkCanalInstance?.id}" />
					<g:link class="edit" action="edit" id="${sdkCanalInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
