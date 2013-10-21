
<%@ page import="com.sp.domain.Canal" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'canal.label', default: 'Canal')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-canal" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<!-- <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> -->
				<li><g:link class="create" controller="smsCanal" action="create">新建短信通道</g:link></li>
				<li><g:link class="create" controller="wapCanal" action="create">新建wap通道</g:link></li>
				<li><g:link class="create" controller="sdkCanal" action="create">新建sdk通道</g:link></li>
			</ul>
		</div>
		<div id="list-canal" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'canal.name.label', default: '名称')}" />
					
						<g:sortableColumn property="class" title="${message(code: 'canal.class.label', default: '类型')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'canal.city.label', default: 'City')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'canal.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="enable" title="${message(code: 'canal.enable.label', default: 'Enable')}" />
					
						<g:sortableColumn property="exeEnd" title="${message(code: 'canal.exeEnd.label', default: 'Exe End')}" />
					
						<g:sortableColumn property="exeStart" title="${message(code: 'canal.exeStart.label', default: 'Exe Start')}" />
					
						<g:sortableColumn property="interval" title="${message(code: 'canal.interval.label', default: 'Interval')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${canalInstanceList}" status="i" var="canalInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link controller="${sp.canalTypeEn(type:canalInstance.class.toString())}" action="show" id="${canalInstance.id}">${fieldValue(bean: canalInstance, field: "name")}</g:link></td>
					
						<td><sp:canalType type="${fieldValue(bean: canalInstance, field: "class")}"></sp:canalType>
						</td>
					
						<td><g:link action="show" id="${canalInstance.id}">${fieldValue(bean: canalInstance, field: "city")}</g:link></td>
					
						<td><g:formatDate date="${canalInstance.dateCreated}" /></td>
					
						<td><g:formatBoolean boolean="${canalInstance.enable}" /></td>
					
						<td>${fieldValue(bean: canalInstance, field: "exeEnd")}</td>
					
						<td>${fieldValue(bean: canalInstance, field: "exeStart")}</td>
					
						<td>${fieldValue(bean: canalInstance, field: "interval")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${canalInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
