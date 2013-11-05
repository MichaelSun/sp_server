
<%@ page import="com.sp.domain.Channel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'channel.label', default: 'Channel')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-channel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-channel" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list channel">
			
				<g:if test="${channelInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="channel.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${channelInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${channelInstance?.mainCode}">
				<li class="fieldcontain">
					<span id="mainCode-label" class="property-label"><g:message code="channel.mainCode.label" default="Main Code" /></span>
					
						<span class="property-value" aria-labelledby="mainCode-label"><g:fieldValue bean="${channelInstance}" field="mainCode"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${channelInstance?.rate}">
				<li class="fieldcontain">
					<span id="rate-label" class="property-label"><g:message code="channel.rate.label" default="Rate" /></span>
					
						<span class="property-value" aria-labelledby="rate-label"><g:fieldValue bean="${channelInstance}" field="rate"/></span>
					
				</li>
				</g:if>
				<g:if test="${channelInstance?.activeDelay}">
				<li class="fieldcontain">
					<span id="activeDelay-label" class="property-label"><g:message code="channel.activeDelay.label" default="activeDelay" /></span>
					
						<span class="property-value" aria-labelledby="activeDelay-label"><g:fieldValue bean="${channelInstance}" field="activeDelay"/></span>
					
				</li>
				</g:if>
			
				
				<g:if test="${channelInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="channel.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${channelInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${channelInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="channel.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${channelInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${channelInstance?.id}" />
					<g:link class="edit" action="edit" id="${channelInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
