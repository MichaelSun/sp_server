
<%@ page import="com.sp.domain.SubAppItem"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'subAppItem.label', default: 'SubAppItem')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-subAppItem" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-subAppItem" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<th class="sortable">序号</th>
					<th>渠道号</th>


					<th>版本号</th>
					<th>imei</th>
					<th>imsi</th>
					<th>serialNumber</th>
					<th>网络类型</th>
					<th>短信中心</th>

					<th>省市</th>

					<th>手机型号</th>
					<th>安卓版本号</th>

					<th>注册日期</th>
					<th>访问日期</th>


				</tr>
			</thead>
			<tbody>
				<g:each in="${subAppItemInstanceList}" status="i"
					var="subAppItemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${subAppItemInstance.id}">
								${fieldValue(bean: subAppItemInstance, field: "id")}
							</g:link></td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "channelCode")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "appVersion")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "imei")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "imsi")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "serialNumber")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "netType")}
						</td>

						<td>
							${fieldValue(bean: subAppItemInstance, field: "smsCenter")}
						</td>
						<td>
							${fieldValue(bean: subAppItemInstance, field: "province")} ${fieldValue(bean: subAppItemInstance, field: "city")}
						</td>




						<td>
							${fieldValue(bean: subAppItemInstance, field: "phoneType")}
						</td>




						<td>
							${fieldValue(bean: subAppItemInstance, field: "androidVersion")}
						</td>

						<td><g:formatDate date="${subAppItemInstance.dateCreated}"
								format="yyyy/MM/dd hh:mm:ss" /></td>

						<td><g:formatDate date="${subAppItemInstance.lastUpdated}"
								format="yyyy/MM/dd hh:mm:ss" /></td>


					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${subAppItemInstanceTotal}" />
		</div>
	</div>
</body>
</html>
