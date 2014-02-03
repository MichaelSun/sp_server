
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
		${params.canalName }
	</h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>
	</g:if>
	<div class="nav" role="search">
		<form
			action="${createLink(uri:'/adminDailyCanalActive')}/${params.canalName }"
			method="post">
			<ul>

				<li>
					<fieldset class="form">
						<g:datePicker name="sdate" value="${datePicker}"
							noSelection="['':'-选择-']" precision="day" years="${2013..2020}" />
					</fieldset>
				</li>
				<li>
					<fieldset class="buttons">
						<g:submitButton name="search" value="查询" />
					</fieldset>
				</li>


			</ul>
		</form>
	</div>
	<div id="list-DailyCanalActive" class="content scaffold-list"
		role="main">
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<g:sortableColumn property="canalName"
						title="${message(code: 'DailyCanalActive.canalName.label', default: '通道名称')}" />

					<g:sortableColumn property="num"
						title="${message(code: 'DailyCanalActive.num.label', default: '数量')}" />
					<g:sortableColumn property="day"
						title="${message(code: 'DailyCanalActive.day.label', default: '时间')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${dailyCanalActiveInstanceList}" status="i"
					var="dailyCanalActiveInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							${fieldValue(bean: dailyCanalActiveInstance, field: "id")}
						</td>


						<td><g:link controller="adminDailyCanalActive"
								action="${dailyCanalActiveInstance.canalName }">
								${fieldValue(bean: dailyCanalActiveInstance, field: "canalName")}
							</g:link></td>

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
	</div>
</body>
</html>
