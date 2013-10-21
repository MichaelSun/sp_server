<%@ page import="com.sp.domain.Canal" %>



<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="canal.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${canalInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="canal.enable.label" default="Enable" />
		
	</label>
	<g:checkBox name="enable" value="${canalInstance?.enable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="canal.exeEnd.label" default="Exe End" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${canalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="canal.exeStart.label" default="Exe Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${canalInstance.exeStart}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="canal.interval.label" default="Interval" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${canalInstance.interval}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="canal.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${canalInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'operator', 'error')} ">
	<label for="operator">
		<g:message code="canal.operator.label" default="Operator" />
		
	</label>
	<g:textField name="operator" value="${canalInstance?.operator}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'province', 'error')} ">
	<label for="province">
		<g:message code="canal.province.label" default="Province" />
		
	</label>
	<g:textField name="province" value="${canalInstance?.province}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="canal.times.label" default="Times" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${canalInstance.times}" required=""/>
</div>

