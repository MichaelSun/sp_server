
<%@ page import="com.sp.domain.WapCanal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'wapCanal.label', default: 'WapCanal')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-wapCanal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-wapCanal" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'wapCanal.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="operator" title="${message(code: 'wapCanal.operator.label', default: 'Operator')}" />
					
						<g:sortableColumn property="province" title="${message(code: 'wapCanal.province.label', default: 'Province')}" />
					
						<g:sortableColumn property="chargeKey" title="${message(code: 'wapCanal.chargeKey.label', default: 'Charge Key')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'wapCanal.city.label', default: 'City')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'wapCanal.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${wapCanalInstanceList}" status="i" var="wapCanalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${wapCanalInstance.id}">${fieldValue(bean: wapCanalInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: wapCanalInstance, field: "operator")}</td>
					
						<td>${fieldValue(bean: wapCanalInstance, field: "province")}</td>
					
						<td>${fieldValue(bean: wapCanalInstance, field: "chargeKey")}</td>
					
						<td>${fieldValue(bean: wapCanalInstance, field: "city")}</td>
					
						<td><g:formatDate date="${wapCanalInstance.dateCreated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${wapCanalInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
