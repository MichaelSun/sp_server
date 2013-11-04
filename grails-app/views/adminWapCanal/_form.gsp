<%@ page import="com.sp.domain.WapCanal" %>



<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="wapCanal.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${wapCanalInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'operator', 'error')} required">
	<label for="operator">
		<g:message code="wapCanal.operator.label" default="Operator" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="operator" required="" value="${wapCanalInstance?.operator}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'chargeKey', 'error')} ">
	<label for="chargeKey">
		<g:message code="wapCanal.chargeKey.label" default="Charge Key" />
		
	</label>
	<g:textField name="chargeKey" value="${wapCanalInstance?.chargeKey}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="wapCanal.enable.label" default="Enable" />
		
	</label>
	<g:checkBox name="enable" value="${wapCanalInstance?.enable}" />
</div>



<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="wapCanal.exeEnd.label" default="Exe End" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${wapCanalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="wapCanal.exeStart.label" default="Exe Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${wapCanalInstance.exeStart}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'gateWay', 'error')} ">
	<label for="gateWay">
		<g:message code="wapCanal.gateWay.label" default="Gate Way" />
		
	</label>
	<g:textField name="gateWay" value="${wapCanalInstance?.gateWay}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="wapCanal.interval.label" default="Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${wapCanalInstance.interval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'blockNum', 'error')} required">
	<label for="start">
		<g:message code="wapCanal.start.label" default="blockNum" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockNum" type="text" value="${wapCanalInstance.blockNum}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'blockKeys', 'error')} required">
	<label for="end">
		<g:message code="wapCanal.end.label" default="blockKeys" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockKeys" type="text" value="${wapCanalInstance.blockKeys}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'targetKey', 'error')} ">
	<label for="targetKey">
		<g:message code="wapCanal.targetKey.label" default="Target Key" />
		
	</label>
	<g:textField name="targetKey" value="${wapCanalInstance?.targetKey}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wapCanalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="wapCanal.times.label" default="Times" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${wapCanalInstance.times}" required=""/>
</div>

<g:render template="province_city_tpl"/>