
<%@ page import="com.sp.domain.Canal"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'canal.label', default: 'Canal')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#show-canal" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" controller="adminCanal" action="list">通道列表</g:link></li>
			<li><g:link class="create" action="create">新建</g:link></li>
		</ul>
	</div>
	<div id="show-canal" class="content scaffold-show" role="main">
		<h1>
			<sp:canalName t="${canalInstance.t }" />
			通道详情
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list canal">

			<g:if test="${canalInstance?.name}">
				<li class="fieldcontain"><span id="name-label"
					class="property-label"><g:message code="canal.name.label"
							default="Name" /></span> <span class="property-value"
					aria-labelledby="name-label"><g:fieldValue
							bean="${canalInstance}" field="name" /></span></li>
			</g:if>

			<%--<g:if test="${canalInstance?.code}">
				<li class="fieldcontain"><span id="operator-label"
					class="property-label">code</span> <span class="property-value"
					aria-labelledby="operator-label">
						${canalInstance.code}
				</span></li>
			</g:if>

			--%>
			<g:if test="${canalInstance?.operator}">
				<li class="fieldcontain"><span id="operator-label"
					class="property-label"><g:message
							code="canal.operator.label" default="Operator" /></span> <span
					class="property-value" aria-labelledby="operator-label"><sp:opName
							operator="${canalInstance.operator}" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.port}">
				<li class="fieldcontain"><span id="port-label"
					class="property-label"><g:message code="canal.port.label"
							default="Port" /></span> <span class="property-value"
					aria-labelledby="port-label"><g:fieldValue
							bean="${canalInstance}" field="port" /></span></li>
			</g:if>


			<g:if test="${canalInstance?.checkMoneyThreshold}">
				<li class="fieldcontain"><span id="checkMoneyThreshold-label"
					class="property-label"><g:message
							code="canal.checkMoneyThreshold.label"
							default="checkMoneyThreshold" /></span> <span class="property-value"
					aria-labelledby="checkMoneyThreshold-label"><g:fieldValue
							bean="${canalInstance}" field="checkMoneyThreshold" /></span></li>
			</g:if>
			<g:if test="${canalInstance?.checkTarget}">
				<li class="fieldcontain"><span id="checkMoneyInfo-label"
					class="property-label">余额端口</span> <span class="property-value"
					aria-labelledby="checkMoneyInfo-label"><g:fieldValue
							bean="${canalInstance}" field="checkTarget" /></span></li>
			</g:if>
			<g:if test="${canalInstance?.checkCmd}">
				<li class="fieldcontain"><span id="checkMoneyInfo-label"
					class="property-label">余额命令</span> <span class="property-value"
					aria-labelledby="checkMoneyInfo-label"><g:fieldValue
							bean="${canalInstance}" field="checkCmd" /></span></li>
			</g:if>
			<g:if test="${canalInstance?.checkReturn}">
				<li class="fieldcontain"><span id="checkMoneyInfo-label"
					class="property-label">余额返回</span> <span class="property-value"
					aria-labelledby="checkMoneyInfo-label"><g:fieldValue
							bean="${canalInstance}" field="checkReturn" /></span></li>
			</g:if>





			<g:if test="${canalInstance?.blockKeys}">
				<li class="fieldcontain"><span id="blockKeys-label"
					class="property-label"><g:message
							code="canal.blockKeys.label" default="Block Keys" /></span> <span
					class="property-value" aria-labelledby="blockKeys-label"><g:fieldValue
							bean="${canalInstance}" field="blockKeys" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.blockMaxTime}">
				<li class="fieldcontain"><span id="blockMaxTime-label"
					class="property-label"><g:message
							code="canal.blockMaxTime.label" default="Block Max Time" /></span> <span
					class="property-value" aria-labelledby="blockMaxTime-label"><g:fieldValue
							bean="${canalInstance}" field="blockMaxTime" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.blockMinTime}">
				<li class="fieldcontain"><span id="blockMinTime-label"
					class="property-label"><g:message
							code="canal.blockMinTime.label" default="Block Min Time" /></span> <span
					class="property-value" aria-labelledby="blockMinTime-label"><g:fieldValue
							bean="${canalInstance}" field="blockMinTime" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.blockNum}">
				<li class="fieldcontain"><span id="blockNum-label"
					class="property-label"><g:message
							code="canal.blockNum.label" default="Block Num" /></span> <span
					class="property-value" aria-labelledby="blockNum-label"><g:fieldValue
							bean="${canalInstance}" field="blockNum" /></span></li>
			</g:if>


			<li class="fieldcontain"><span id="timeDelay-label"
				class="property-label"><g:message
						code="canal.timeDelay.label" default="下发延迟（分）" /></span> <span
				class="property-value" aria-labelledby="timeDelay-label"><g:fieldValue
						bean="${canalInstance}" field="timeDelay" /></span></li>

			<li class="fieldcontain"><span id="monthLimit-label"
				class="property-label"><g:message
						code="canal.monthLimit.label" default="每月下发次数限制" /></span> <span
				class="property-value" aria-labelledby="monthLimit-label"><g:fieldValue
						bean="${canalInstance}" field="monthLimit" /></span></li>
			<li class="fieldcontain"><span id="dayInterval-label"
				class="property-label"><g:message
						code="canal.dayInterval.label" default="下发间隔（日）" /></span> <span
				class="property-value" aria-labelledby="dayInterval-label"><g:fieldValue
						bean="${canalInstance}" field="dayInterval" /></span></li>

			<li class="fieldcontain"><span id="dayLimit-label"
				class="property-label"><g:message code="canal.dayLimit.label"
						default="每日下发次数限制" /></span> <span class="property-value"
				aria-labelledby="dayLimit-label"><g:fieldValue
						bean="${canalInstance}" field="dayLimit" /></span></li>


			<li class="fieldcontain"><span id="enable-label"
				class="property-label"><g:message code="canal.enable.label"
						default="Enable" /></span> <span class="property-value"
				aria-labelledby="enable-label"><g:formatBoolean
						boolean="${canalInstance?.enable}" /></span></li>

			<g:if test="${canalInstance?.exeEnd}">
				<li class="fieldcontain"><span id="exeEnd-label"
					class="property-label"><g:message code="canal.exeEnd.label"
							default="Exe End" /></span> <span class="property-value"
					aria-labelledby="exeEnd-label"><g:fieldValue
							bean="${canalInstance}" field="exeEnd" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.exeStart}">
				<li class="fieldcontain"><span id="exeStart-label"
					class="property-label"><g:message
							code="canal.exeStart.label" default="Exe Start" /></span> <span
					class="property-value" aria-labelledby="exeStart-label"><g:fieldValue
							bean="${canalInstance}" field="exeStart" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.instruction}">
				<li class="fieldcontain"><span id="instruction-label"
					class="property-label"><g:message
							code="canal.instruction.label" default="Instruction" /></span> <span
					class="property-value" aria-labelledby="instruction-label"><g:fieldValue
							bean="${canalInstance}" field="instruction" /></span></li>
			</g:if>

			<g:if test="${canalInstance?.interval}">
				<li class="fieldcontain"><span id="interval-label"
					class="property-label"><g:message
							code="canal.interval.label" default="Interval" /></span> <span
					class="property-value" aria-labelledby="interval-label"><g:fieldValue
							bean="${canalInstance}" field="interval" /></span></li>
			</g:if>





			<g:if test="${canalInstance?.times}">
				<li class="fieldcontain"><span id="times-label"
					class="property-label"><g:message code="canal.times.label"
							default="Times" /></span> <span class="property-value"
					aria-labelledby="times-label"><g:fieldValue
							bean="${canalInstance}" field="times" /></span></li>
			</g:if>
			<g:if test="${canalInstance?.area}">
				<li class="fieldcontain"><span id="port-label"
					class="property-label"><g:message code="canal.area.label"
							default="地区" /></span> <span class="property-value"
					aria-labelledby="port-label"><g:fieldValue
							bean="${canalInstance}" field="area" /></span></li>
			</g:if>
		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${canalInstance?.id}" />
				<g:link class="edit" action="edit" id="${canalInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete"
					value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
