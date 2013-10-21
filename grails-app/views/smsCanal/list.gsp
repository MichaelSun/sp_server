
<%@ page import="com.sp.domain.SmsCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'smsCanal.label', default: 'SmsCanal')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-smsCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-smsCanal" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="blockKeys" title="${message(code: 'smsCanal.blockKeys.label', default: 'Block Keys')}" />
					
						<g:sortableColumn property="blockMaxTime" title="${message(code: 'smsCanal.blockMaxTime.label', default: 'Block Max Time')}" />
					
						<g:sortableColumn property="blockMinTime" title="${message(code: 'smsCanal.blockMinTime.label', default: 'Block Min Time')}" />
					
						<g:sortableColumn property="blockNum" title="${message(code: 'smsCanal.blockNum.label', default: 'Block Num')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'smsCanal.city.label', default: 'City')}" />
					
						<g:sortableColumn property="dayInterval" title="${message(code: 'smsCanal.dayInterval.label', default: 'Day Interval')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${smsCanalInstanceList}" status="i" var="smsCanalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${smsCanalInstance.id}">${fieldValue(bean: smsCanalInstance, field: "blockKeys")}</g:link></td>
					
						<td>${fieldValue(bean: smsCanalInstance, field: "blockMaxTime")}</td>
					
						<td>${fieldValue(bean: smsCanalInstance, field: "blockMinTime")}</td>
					
						<td>${fieldValue(bean: smsCanalInstance, field: "blockNum")}</td>
					
						<td>${fieldValue(bean: smsCanalInstance, field: "city")}</td>
					
						<td>${fieldValue(bean: smsCanalInstance, field: "dayInterval")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${smsCanalInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
