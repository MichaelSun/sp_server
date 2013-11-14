
<%@ page import="com.sp.domain.stat.DailyCanalActive"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'DailyCanalActive.label', default: 'DailyCanalActive')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-DailyCanalActive" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
		</ul>
	</div>
	<h1>
		<g:message code="default.list.label" args="[entityName]" />
	</h1>
	<div id="list-DailyCanalActive" class="content scaffold-list"
		role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<th>序号</th>


					<g:sortableColumn property="canalName"
						title="${message(code: 'DailyCanalActive.canalName.label', default: 'canalName')}" />

					<g:sortableColumn property="num"
						title="${message(code: 'DailyCanalActive.num.label', default: 'Num')}" />
					<g:sortableColumn property="day"
						title="${message(code: 'DailyCanalActive.day.label', default: 'Day')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${dailyCanalActiveInstanceList}" status="i"
					var="dailyCanalActiveInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							${fieldValue(bean: dailyCanalActiveInstance, field: "id")}
						</td>


						<td>
							${fieldValue(bean: dailyCanalActiveInstance, field: "canalName")}
						</td>

						<td>
							${fieldValue(bean: dailyCanalActiveInstance, field: "num")}
						</td>

						<td>
							${fieldValue(bean: dailyCanalActiveInstance, field: "day")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${dailyCanalActiveInstanceTotal}" />
		</div>
	</div>
</body>
</html>
