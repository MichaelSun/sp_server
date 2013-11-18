
<%@ page import="com.sp.domain.stat.DailyChannelActive"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'dailyChannelActive.label', default: 'DailyChannelActive')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-dailyChannelActive" class="skip" tabindex="-1"><g:message
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
	<div class="nav" role="search">
		<form
			action="${createLink(uri:'/adminDailyChannelActive')}/${params.canalName }"
			method="post">
			<ul>

				<li>
					<fieldset class="form">
						<g:datePicker name="sdate" value="${datePicker}"
							noSelection="['':'-选择-']" precision="month" years="${2013..2020}" />
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
	<div id="list-dailyChannelActive" class="content scaffold-list"
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
					<g:sortableColumn property="day"
						title="${message(code: 'dailyChannelActive.day.label', default: 'Day')}" />
					<g:sortableColumn property="mainCode"
						title="${message(code: 'dailyChannelActive.channelCode.label', default: '主渠道')}" />

					<g:sortableColumn property="channelCode"
						title="${message(code: 'dailyChannelActive.channelCode.label', default: 'Channel Code')}" />

					<g:sortableColumn property="num"
						title="${message(code: 'dailyChannelActive.num.label', default: 'Num')}" />
					<th>rateNum</th>
					<g:sortableColumn property="rate"
						title="${message(code: 'dailyChannelActive.rate.label', default: 'Rate')}" />

				</tr>
			</thead>
			<tbody>
				<g:each in="${dailyChannelActiveInstanceList}" status="i"
					var="dailyChannelActiveInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							${fieldValue(bean: dailyChannelActiveInstance, field: "id")}
						</td>

						<td>
							${fieldValue(bean: dailyChannelActiveInstance, field: "day")}
						</td>

						<td><g:link controller="adminDailyChannelActive"
								action="${sp.getMainCode(code:dailyChannelActiveInstance.channelCode) }">
								${sp.getMainCode(code:dailyChannelActiveInstance.channelCode)}
							</g:link></td>
						<td><g:link controller="adminDailyChannelActive"
								action="${dailyChannelActiveInstance.channelCode }">
								${fieldValue(bean: dailyChannelActiveInstance, field: "channelCode")}
							</g:link></td>
						<td>
							${fieldValue(bean: dailyChannelActiveInstance, field: "num")}
						</td>
						<td><sp:rater num="${dailyChannelActiveInstance.num}"
								rate="${dailyChannelActiveInstance.rate}"></sp:rater></td>

						<td>
							${fieldValue(bean: dailyChannelActiveInstance, field: "rate")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>

	</div>
</body>
</html>
