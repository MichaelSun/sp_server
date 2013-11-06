
<%@ page import="com.sp.domain.SpDomain" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'spDomain.label', default: 'SpDomain')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-spDomain" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-spDomain" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'spDomain.name.label', default: 'Name')}" />
						<g:sortableColumn property="enable" title="${message(code: 'spDomain.enable.label', default: 'Enable')}" />
					
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${spDomainInstanceList}" status="i" var="spDomainInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${spDomainInstance.id}">${fieldValue(bean: spDomainInstance, field: "name")}</g:link></td>
						<td>${fieldValue(bean: spDomainInstance, field: "enable")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${spDomainInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
