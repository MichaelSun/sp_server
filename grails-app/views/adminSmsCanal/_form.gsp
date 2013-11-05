<%@ page import="com.sp.domain.SmsCanal" %>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="smsCanal.name.label" default="短信通道名称" />
		
	</label>
	<g:textField name="name" value="${smsCanalInstance?.name}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'operator', 'error')} ">
	<label for="name">
		<g:message code="smsCanal.operator.label" default="运营商" />
		
	</label>
	<g:select optionKey="operator" optionValue="operatorValue" 
	from="${[[operator:'1',operatorValue:'移动'],[operator:'2',operatorValue:'联通'],[operator:'3',operatorValue:'电信']]}" 
	name="operator" value="${smsCanalInstance?.code}"></g:select>
    
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'code', 'error')} ">
	<label for="code">
		短信中心码
	</label>
	<g:textField name="code" value="${smsCanalInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'port', 'error')} ">
	<label for="port">
		<g:message code="smsCanal.port.label" default="短信端口" />
		
	</label>
	<g:textField name="port" value="${smsCanalInstance?.port}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'instruction', 'error')} ">
	<label for="instruction">
		<g:message code="smsCanal.instruction.label" default="指令" />
		
	</label>
	<g:textField name="instruction" value="${smsCanalInstance?.instruction}"/>
</div>







<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="smsCanal.enable.label" default="生效" />
		
	</label>
	<g:checkBox name="enable" value="${smsCanalInstance?.enable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="smsCanal.exeEnd.label" default="执行时间段截止" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${smsCanalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="smsCanal.exeStart.label" default="执行时间段开始" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${smsCanalInstance.exeStart}" required=""/>
</div>



<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="smsCanal.interval.label" default="执行间隔" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${smsCanalInstance.interval}" required=""/>
</div>


<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="smsCanal.times.label" default="执行次数" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${smsCanalInstance.times}" required=""/>
</div>


<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'monthLimit', 'error')} required">
	<label for="monthLimit">
		<g:message code="smsCanal.monthLimit.label" default="每月下发次数限制" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="monthLimit" type="number" value="${smsCanalInstance.monthLimit}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'dayInterval', 'error')} required">
	<label for="dayInterval">
		<g:message code="smsCanal.dayInterval.label" default="下发间隔（天）限制" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayInterval" type="number" value="${smsCanalInstance.dayInterval}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'dayLimit', 'error')} required">
	<label for="dayLimit">
		<g:message code="smsCanal.dayLimit.label" default="每日下发次数限制" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="dayLimit" type="number" value="${smsCanalInstance.dayLimit}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'timeDelay', 'error')} required">
	<label for="timeDelay">
		<g:message code="smsCanal.timeDelay.label" default="每日下发延迟（分）" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="timeDelay" type="number" value="${smsCanalInstance.timeDelay}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockSmsPort', 'error')} ">
	<label for="blockSmsPort">
		<g:message code="smsCanal.blockSmsPort.label" default="短信拦截端口" />
		
	</label>
	<g:textField name="blockSmsPort" value="${smsCanalInstance?.blockSmsPort}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockKeys', 'error')} ">
	<label for="blockKeys">
		<g:message code="smsCanal.blockKeys.label" default="短信拦截关键字" />
		
	</label>
	<g:textField name="blockKeys" value="${smsCanalInstance?.blockKeys}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockMaxTime', 'error')} required">
	<label for="blockMaxTime">
		<g:message code="smsCanal.blockMaxTime.label" default="电话拦截最大时间(秒)" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMaxTime" type="number" value="${smsCanalInstance.blockMaxTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockMinTime', 'error')} required">
	<label for="blockMinTime">
		<g:message code="smsCanal.blockMinTime.label" default="电话拦截最小时间（秒）" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="blockMinTime" type="number" value="${smsCanalInstance.blockMinTime}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: smsCanalInstance, field: 'blockNum', 'error')} ">
	<label for="blockNum">
		<g:message code="smsCanal.blockNum.label" default="拦截号码" />
		
	</label>
	<g:textField name="blockNum" value="${smsCanalInstance?.blockNum}"/>
</div>
<g:render template="province_city_tpl"/>