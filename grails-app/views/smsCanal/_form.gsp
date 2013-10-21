<%@ page import="com.sp.domain.SmsCanal" %>



<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockKeys', 'error')} ">
	<label for="blockKeys">
		<g:message code="smsCanal.blockKeys.label" default="Block Keys" />
		
	</label>
	<g:textField name="blockKeys" value="${smsCanalInstance?.blockKeys}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockMaxTime', 'error')} required">
	<label for="blockMaxTime">
		<g:message code="smsCanal.blockMaxTime.label" default="Block Max Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMaxTime" type="number" value="${smsCanalInstance.blockMaxTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockMinTime', 'error')} required">
	<label for="blockMinTime">
		<g:message code="smsCanal.blockMinTime.label" default="Block Min Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMinTime" type="number" value="${smsCanalInstance.blockMinTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockNum', 'error')} ">
	<label for="blockNum">
		<g:message code="smsCanal.blockNum.label" default="Block Num" />
		
	</label>
	<g:textField name="blockNum" value="${smsCanalInstance?.blockNum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="smsCanal.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${smsCanalInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'dayInterval', 'error')} required">
	<label for="dayInterval">
		<g:message code="smsCanal.dayInterval.label" default="Day Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayInterval" type="number" value="${smsCanalInstance.dayInterval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'dayLimit', 'error')} required">
	<label for="dayLimit">
		<g:message code="smsCanal.dayLimit.label" default="Day Limit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayLimit" type="number" value="${smsCanalInstance.dayLimit}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="smsCanal.enable.label" default="Enable" />
		
	</label>
	<g:checkBox name="enable" value="${smsCanalInstance?.enable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="smsCanal.exeEnd.label" default="Exe End" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${smsCanalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="smsCanal.exeStart.label" default="Exe Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${smsCanalInstance.exeStart}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'instruction', 'error')} ">
	<label for="instruction">
		<g:message code="smsCanal.instruction.label" default="Instruction" />
		
	</label>
	<g:textField name="instruction" value="${smsCanalInstance?.instruction}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="smsCanal.interval.label" default="Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${smsCanalInstance.interval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'monthLimit', 'error')} required">
	<label for="monthLimit">
		<g:message code="smsCanal.monthLimit.label" default="Month Limit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="monthLimit" type="number" value="${smsCanalInstance.monthLimit}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="smsCanal.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${smsCanalInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'operator', 'error')} ">
	<label for="operator">
		<g:message code="smsCanal.operator.label" default="Operator" />
		
	</label>
	<g:textField name="operator" value="${smsCanalInstance?.operator}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'port', 'error')} ">
	<label for="port">
		<g:message code="smsCanal.port.label" default="Port" />
		
	</label>
	<g:textField name="port" value="${smsCanalInstance?.port}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'province', 'error')} ">
	<label for="province">
		<g:message code="smsCanal.province.label" default="Province" />
		
	</label>
	<g:textField name="province" value="${smsCanalInstance?.province}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="smsCanal.times.label" default="Times" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${smsCanalInstance.times}" required=""/>
</div>

