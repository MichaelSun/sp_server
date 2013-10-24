
<%@ page import="com.sp.domain.SdkCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sdkCanal.label', default: 'SdkCanal')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-sdkCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-sdkCanal" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'sdkCanal.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="operator" title="${message(code: 'sdkCanal.operator.label', default: 'Operator')}" />
					
						<g:sortableColumn property="area" title="${message(code: 'sdkCanal.area.label', default: 'Area')}" />
					
						<g:sortableColumn property="blockKeys" title="${message(code: 'sdkCanal.blockKeys.label', default: 'Block Keys')}" />
					
						<g:sortableColumn property="blockMaxTime" title="${message(code: 'sdkCanal.blockMaxTime.label', default: 'Block Max Time')}" />
					
						<g:sortableColumn property="blockMinTime" title="${message(code: 'sdkCanal.blockMinTime.label', default: 'Block Min Time')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${sdkCanalInstanceList}" status="i" var="sdkCanalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${sdkCanalInstance.id}">${fieldValue(bean: sdkCanalInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: sdkCanalInstance, field: "operator")}</td>
					
						<td>${fieldValue(bean: sdkCanalInstance, field: "area")}</td>
					
						<td>${fieldValue(bean: sdkCanalInstance, field: "blockKeys")}</td>
					
						<td>${fieldValue(bean: sdkCanalInstance, field: "blockMaxTime")}</td>
					
						<td>${fieldValue(bean: sdkCanalInstance, field: "blockMinTime")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${sdkCanalInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
