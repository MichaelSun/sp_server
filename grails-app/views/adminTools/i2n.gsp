
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
			<li><g:link class="create" action="loadImeiPn"
					onclick="return confirm('将重新扫描文件，是否执行？');">执行加载</g:link></li>

		</ul>
	</div>
	<h1>
		imei-pn表
	</h1>
		
	<div id="list-cityMap" class="content scaffold-list" role="main">

		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		${result }

	</div>
</body>
</html>
