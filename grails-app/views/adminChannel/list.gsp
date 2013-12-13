
<%@ page import="com.sp.domain.Channel"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'channel.label', default: 'Channel')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-channel" class="skip" tabindex="-1"><g:message
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
	<h1>
		<g:message code="default.list.label" args="[entityName]" />
	</h1>
	<div id="list-channel" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="name"
						title="${message(code: 'channel.name.label', default: 'Name')}" />
					<g:sortableColumn property="mainCode"
						title="${message(code: 'channel.mainCode.label', default: 'Main Code')}" />

					<%--<g:sortableColumn property="subCode" title="${message(code: 'channel.subCode.label', default: 'Sub Code')}" />--%>
					<g:sortableColumn property="rate"
						title="${message(code: 'channel.rate.label', default: 'Rate')}" />
					<th>激活延迟（分钟）</th>
					<th>rate生效点</th>

					<g:sortableColumn property="dateCreated"
						title="${message(code: 'channel.dateCreated.label', default: 'Date Created')}" />

					<g:sortableColumn property="lastUpdated"
						title="${message(code: 'channel.lastUpdated.label', default: 'Last Updated')}" />


				</tr>
			</thead>
			<tbody>
				<g:each in="${channelInstanceList}" status="i" var="channelInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${channelInstance.id}">
								${fieldValue(bean: channelInstance, field: "name")}
							</g:link></td>
						<td><g:link controller="adminDailyChannelActive" action="${channelInstance.mainCode }">
								${fieldValue(bean: channelInstance, field: "mainCode")}
							</g:link></td>

						<%--<td>${fieldValue(bean: channelInstance, field: "subCode")}</td>
						
						--%>
						<td>
							${fieldValue(bean: channelInstance, field: "rate")}
						</td>
						<td>
							${channelInstance.activeDelay}
						</td>
						<td>
							${channelInstance.rateBegin}
						</td>

						<td>
							${fieldValue(bean: channelInstance, field: "dateCreated")}
						</td>





						<td><g:formatDate date="${channelInstance.lastUpdated}" /></td>


					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${channelInstanceTotal}" />
		</div>
	</div>
</body>
</html>
