<%@ page import="com.sp.domain.SdkCanal" %>



<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="sdkCanal.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sdkCanalInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'operator', 'error')} required">
	<label for="operator">
		<g:message code="sdkCanal.operator.label" default="Operator" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="operator" required="" value="${sdkCanalInstance?.operator}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'blockKeys', 'error')} ">
	<label for="blockKeys">
		<g:message code="sdkCanal.blockKeys.label" default="Block Keys" />
		
	</label>
	<g:textField name="blockKeys" value="${sdkCanalInstance?.blockKeys}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'blockMaxTime', 'error')} required">
	<label for="blockMaxTime">
		<g:message code="sdkCanal.blockMaxTime.label" default="Block Max Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMaxTime" type="number" value="${sdkCanalInstance.blockMaxTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'blockMinTime', 'error')} required">
	<label for="blockMinTime">
		<g:message code="sdkCanal.blockMinTime.label" default="Block Min Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMinTime" type="number" value="${sdkCanalInstance.blockMinTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'blockNum', 'error')} ">
	<label for="blockNum">
		<g:message code="sdkCanal.blockNum.label" default="Block Num" />
		
	</label>
	<g:textField name="blockNum" value="${sdkCanalInstance?.blockNum}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'dayInterval', 'error')} required">
	<label for="dayInterval">
		<g:message code="sdkCanal.dayInterval.label" default="Day Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayInterval" type="number" value="${sdkCanalInstance.dayInterval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'dayLimit', 'error')} required">
	<label for="dayLimit">
		<g:message code="sdkCanal.dayLimit.label" default="Day Limit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayLimit" type="number" value="${sdkCanalInstance.dayLimit}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="sdkCanal.enable.label" default="Enable" />
		
	</label>
	<g:checkBox name="enable" value="${sdkCanalInstance?.enable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="sdkCanal.exeEnd.label" default="Exe End" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${sdkCanalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="sdkCanal.exeStart.label" default="Exe Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${sdkCanalInstance.exeStart}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="sdkCanal.interval.label" default="Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${sdkCanalInstance.interval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'monthLimit', 'error')} required">
	<label for="monthLimit">
		<g:message code="sdkCanal.monthLimit.label" default="Month Limit" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="monthLimit" type="number" value="${sdkCanalInstance.monthLimit}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: sdkCanalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="sdkCanal.times.label" default="Times" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${sdkCanalInstance.times}" required=""/>
</div>

<g:render template="province_city_tpl"/>