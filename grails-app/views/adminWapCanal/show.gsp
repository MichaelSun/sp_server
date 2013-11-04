
<%@ page import="com.sp.domain.WapCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'wapCanal.label', default: 'WapCanal')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-wapCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-wapCanal" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list wapCanal">
			
				<g:if test="${wapCanalInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="wapCanal.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${wapCanalInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.operator}">
				<li class="fieldcontain">
					<span id="operator-label" class="property-label"><g:message code="wapCanal.operator.label" default="Operator" /></span>
					
						<span class="property-value" aria-labelledby="operator-label"><g:fieldValue bean="${wapCanalInstance}" field="operator"/></span>
					
				</li>
				</g:if>
			
				
			
				<g:if test="${wapCanalInstance?.chargeKey}">
				<li class="fieldcontain">
					<span id="chargeKey-label" class="property-label"><g:message code="wapCanal.chargeKey.label" default="Charge Key" /></span>
					
						<span class="property-value" aria-labelledby="chargeKey-label"><g:fieldValue bean="${wapCanalInstance}" field="chargeKey"/></span>
					
				</li>
				</g:if>
			
				
			
				<g:if test="${wapCanalInstance?.area}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="wapCanal.area.label" default="开通地区" /></span>
					
						<span class="property-value" aria-labelledby="area-label"><g:fieldValue bean="${wapCanalInstance}" field="area"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.enable}">
				<li class="fieldcontain">
					<span id="enable-label" class="property-label"><g:message code="wapCanal.enable.label" default="Enable" /></span>
					
						<span class="property-value" aria-labelledby="enable-label"><g:formatBoolean boolean="${wapCanalInstance?.enable}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.blockKeys}">
				<li class="fieldcontain">
					<span id="end-label" class="property-label"><g:message code="wapCanal.end.label" default="blockKeys" /></span>
					
						<span class="property-value" aria-labelledby="end-label"><g:fieldValue bean="${wapCanalInstance}" field="blockKeys"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.exeEnd}">
				<li class="fieldcontain">
					<span id="exeEnd-label" class="property-label"><g:message code="wapCanal.exeEnd.label" default="Exe End" /></span>
					
						<span class="property-value" aria-labelledby="exeEnd-label"><g:fieldValue bean="${wapCanalInstance}" field="exeEnd"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.exeStart}">
				<li class="fieldcontain">
					<span id="exeStart-label" class="property-label"><g:message code="wapCanal.exeStart.label" default="Exe Start" /></span>
					
						<span class="property-value" aria-labelledby="exeStart-label"><g:fieldValue bean="${wapCanalInstance}" field="exeStart"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.gateWay}">
				<li class="fieldcontain">
					<span id="gateWay-label" class="property-label"><g:message code="wapCanal.gateWay.label" default="Gate Way" /></span>
					
						<span class="property-value" aria-labelledby="gateWay-label"><g:fieldValue bean="${wapCanalInstance}" field="gateWay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.interval}">
				<li class="fieldcontain">
					<span id="interval-label" class="property-label"><g:message code="wapCanal.interval.label" default="Interval" /></span>
					
						<span class="property-value" aria-labelledby="interval-label"><g:fieldValue bean="${wapCanalInstance}" field="interval"/></span>
					
				</li>
				</g:if>
			
				
			
				<g:if test="${wapCanalInstance?.blockNum}">
				<li class="fieldcontain">
					<span id="start-label" class="property-label"><g:message code="wapCanal.start.label" default="blockNum" /></span>
					
						<span class="property-value" aria-labelledby="start-label"><g:fieldValue bean="${wapCanalInstance}" field="blockNum"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.targetKey}">
				<li class="fieldcontain">
					<span id="targetKey-label" class="property-label"><g:message code="wapCanal.targetKey.label" default="Target Key" /></span>
					
						<span class="property-value" aria-labelledby="targetKey-label"><g:fieldValue bean="${wapCanalInstance}" field="targetKey"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wapCanalInstance?.times}">
				<li class="fieldcontain">
					<span id="times-label" class="property-label"><g:message code="wapCanal.times.label" default="Times" /></span>
					
						<span class="property-value" aria-labelledby="times-label"><g:fieldValue bean="${wapCanalInstance}" field="times"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${wapCanalInstance?.id}" />
					<g:link class="edit" action="edit" id="${wapCanalInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
