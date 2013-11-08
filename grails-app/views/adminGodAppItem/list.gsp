
<%@ page import="com.sp.domain.GodAppItem"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'godAppItem.label', default: 'GodAppItem')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-godAppItem" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<%--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			--%>
			</ul>
		</div>
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
	<div id="list-godAppItem" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>渠道号</th>
					<th>serialNumber</th>

					<th>版本号</th>
					<th>imei</th>
					<th>imsi</th>
					<th>网络类型</th>

					<th>downUrl</th>



					<th>subAppName</th>

					<th>激活时间</th>
					<th>激活次数</th>



				</tr>
			</thead>
			<tbody>
				<g:each in="${godAppItemInstanceList}" status="i"
					var="godAppItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							${fieldValue(bean: godAppItemInstance, field: "id")}
						</td>
						<td>
							${fieldValue(bean: godAppItemInstance, field: "channelCode")}
						</td>
						<td>
							${fieldValue(bean: godAppItemInstance, field: "serialNumber")}
						</td>

						<td>
							${fieldValue(bean: godAppItemInstance, field: "appVersion")}
						</td>
						<td>
							${fieldValue(bean: godAppItemInstance, field: "imei")}
						</td>
						<td>
							${fieldValue(bean: godAppItemInstance, field: "imsi")}
						</td>

						<td>
							${fieldValue(bean: godAppItemInstance, field: "netType")}
						</td>
						<td>
							${fieldValue(bean: godAppItemInstance, field: "downUrl")}
						</td>



						<td>
							${fieldValue(bean: godAppItemInstance, field: "subAppName")}
						</td>


						<td><g:formatDate date="${godAppItemInstance.activeDate}" /></td>
						<td>${godAppItemInstance.version}</td>



					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${godAppItemInstanceTotal}" />
		</div>
	</div>
</body>
</html>
