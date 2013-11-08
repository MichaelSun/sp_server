
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
			<li><g:link class="create" action="load"
					onclick="return confirm('将重新扫描文件，是否执行？');">执行加载</g:link></li>

		</ul>
	</div>
	<h1>
		<g:message code="default.list.label" args="[entityName]" />(共${count }个)
	</h1>
		
	<div id="list-subAppFile" class="content scaffold-list" role="main">

		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>
					<th>名称</th>

				</tr>
			</thead>
			<tbody>
				<g:each in="${list}" status="i" var="sapp">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td>
							${sapp}
						</td>


					</tr>
				</g:each>
			</tbody>
		</table>

	</div>
</body>
</html>
