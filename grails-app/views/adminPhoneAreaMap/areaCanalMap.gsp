
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'dailyChannelActive.label', default: 'DailyChannelActive')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-subAppFile" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="loadAreaCanalMap"
					onclick="return confirm('将重新加载所有已配置通道，是否执行？');">重新加载所有已配置通道</g:link></li>

		</ul>
	</div>
	<h1>
		代码通道映射图
	</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		
	<div id="list-cityMap" class="content scaffold-list" role="main">

		
		
		<table>
				<thead>
					<tr>
					<th>地区</th>
					<th>渠道</th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${m}" status="i" var="item">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>${item.key}</td>
					
						<td>${item.value}</td>
					
						
					
					</tr>
				</g:each>
				</tbody>
			</table>

	</div>
</body>
</html>
