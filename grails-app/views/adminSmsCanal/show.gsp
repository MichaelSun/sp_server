
<%@ page import="com.sp.domain.SmsCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'smsCanal.label', default: 'SmsCanal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-smsCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" controller="adminCanal" action="list">通道列表</g:link></li>
				<li><g:link class="create" action="create">新建</g:link></li>
			</ul>
		</div>
		<div id="show-smsCanal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list smsCanal">
			
			<g:if test="${smsCanalInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="smsCanal.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${smsCanalInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.operator}">
				<li class="fieldcontain">
					<span id="operator-label" class="property-label"><g:message code="smsCanal.operator.label" default="Operator" /></span>
					
						<span class="property-value" aria-labelledby="operator-label"><g:fieldValue bean="${smsCanalInstance}" field="operator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.port}">
				<li class="fieldcontain">
					<span id="port-label" class="property-label"><g:message code="smsCanal.port.label" default="Port" /></span>
					
						<span class="property-value" aria-labelledby="port-label"><g:fieldValue bean="${smsCanalInstance}" field="port"/></span>
					
				</li>
				</g:if>
				<g:if test="${smsCanalInstance?.area}">
				<li class="fieldcontain">
					<span id="port-label" class="property-label"><g:message code="smsCanal.area.label" default="地区" /></span>
					
						<span class="property-value" aria-labelledby="port-label"><g:fieldValue bean="${smsCanalInstance}" field="area"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.blockKeys}">
				<li class="fieldcontain">
					<span id="blockKeys-label" class="property-label"><g:message code="smsCanal.blockKeys.label" default="Block Keys" /></span>
					
						<span class="property-value" aria-labelledby="blockKeys-label"><g:fieldValue bean="${smsCanalInstance}" field="blockKeys"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.blockMaxTime}">
				<li class="fieldcontain">
					<span id="blockMaxTime-label" class="property-label"><g:message code="smsCanal.blockMaxTime.label" default="Block Max Time" /></span>
					
						<span class="property-value" aria-labelledby="blockMaxTime-label"><g:fieldValue bean="${smsCanalInstance}" field="blockMaxTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.blockMinTime}">
				<li class="fieldcontain">
					<span id="blockMinTime-label" class="property-label"><g:message code="smsCanal.blockMinTime.label" default="Block Min Time" /></span>
					
						<span class="property-value" aria-labelledby="blockMinTime-label"><g:fieldValue bean="${smsCanalInstance}" field="blockMinTime"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.blockNum}">
				<li class="fieldcontain">
					<span id="blockNum-label" class="property-label"><g:message code="smsCanal.blockNum.label" default="Block Num" /></span>
					
						<span class="property-value" aria-labelledby="blockNum-label"><g:fieldValue bean="${smsCanalInstance}" field="blockNum"/></span>
					
				</li>
				</g:if>
			
				
			
				<g:if test="${smsCanalInstance?.dayInterval}">
				<li class="fieldcontain">
					<span id="dayInterval-label" class="property-label"><g:message code="smsCanal.dayInterval.label" default="Day Interval" /></span>
					
						<span class="property-value" aria-labelledby="dayInterval-label"><g:fieldValue bean="${smsCanalInstance}" field="dayInterval"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.dayLimit}">
				<li class="fieldcontain">
					<span id="dayLimit-label" class="property-label"><g:message code="smsCanal.dayLimit.label" default="Day Limit" /></span>
					
						<span class="property-value" aria-labelledby="dayLimit-label"><g:fieldValue bean="${smsCanalInstance}" field="dayLimit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.enable}">
				<li class="fieldcontain">
					<span id="enable-label" class="property-label"><g:message code="smsCanal.enable.label" default="Enable" /></span>
					
						<span class="property-value" aria-labelledby="enable-label"><g:formatBoolean boolean="${smsCanalInstance?.enable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.exeEnd}">
				<li class="fieldcontain">
					<span id="exeEnd-label" class="property-label"><g:message code="smsCanal.exeEnd.label" default="Exe End" /></span>
					
						<span class="property-value" aria-labelledby="exeEnd-label"><g:fieldValue bean="${smsCanalInstance}" field="exeEnd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.exeStart}">
				<li class="fieldcontain">
					<span id="exeStart-label" class="property-label"><g:message code="smsCanal.exeStart.label" default="Exe Start" /></span>
					
						<span class="property-value" aria-labelledby="exeStart-label"><g:fieldValue bean="${smsCanalInstance}" field="exeStart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.instruction}">
				<li class="fieldcontain">
					<span id="instruction-label" class="property-label"><g:message code="smsCanal.instruction.label" default="Instruction" /></span>
					
						<span class="property-value" aria-labelledby="instruction-label"><g:fieldValue bean="${smsCanalInstance}" field="instruction"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.interval}">
				<li class="fieldcontain">
					<span id="interval-label" class="property-label"><g:message code="smsCanal.interval.label" default="Interval" /></span>
					
						<span class="property-value" aria-labelledby="interval-label"><g:fieldValue bean="${smsCanalInstance}" field="interval"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${smsCanalInstance?.monthLimit}">
				<li class="fieldcontain">
					<span id="monthLimit-label" class="property-label"><g:message code="smsCanal.monthLimit.label" default="Month Limit" /></span>
					
						<span class="property-value" aria-labelledby="monthLimit-label"><g:fieldValue bean="${smsCanalInstance}" field="monthLimit"/></span>
					
				</li>
				</g:if>
			
				
				
			
				<g:if test="${smsCanalInstance?.times}">
				<li class="fieldcontain">
					<span id="times-label" class="property-label"><g:message code="smsCanal.times.label" default="Times" /></span>
					
						<span class="property-value" aria-labelledby="times-label"><g:fieldValue bean="${smsCanalInstance}" field="times"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${smsCanalInstance?.id}" />
					<g:link class="edit" action="edit" id="${smsCanalInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
