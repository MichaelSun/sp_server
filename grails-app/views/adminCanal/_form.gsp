<%@ page import="com.sp.domain.Canal" %>


<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 't', 'error')} ">
	<label for="name">
		<g:message code="canal.t.label" default="通道类型" />
		
	</label>
	<g:select optionKey="t" optionValue="tValue" 
	from="${[[t:'1',tValue:'短信'],[t:'2',tValue:'WAP'],[t:'3',tValue:'SDK']]}" 
	name="t" value="${canalInstance?.t}"></g:select>
    
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="canal.name.label" default="短信通道名称" />
		
	</label>
	<g:textField name="name" value="${canalInstance?.name}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'operator', 'error')} ">
	<label for="name">
		<g:message code="canal.operator.label" default="运营商" />
		
	</label>
	<g:select optionKey="operator" optionValue="operatorValue" 
	from="${[[operator:'1',operatorValue:'移动'],[operator:'2',operatorValue:'联通'],[operator:'3',operatorValue:'电信']]}" 
	name="operator" value="${canalInstance?.code}"></g:select>
    
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'code', 'error')} ">
	<label for="code">
		短信中心码
	</label>
	<g:textField name="code" value="${canalInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'port', 'error')} ">
	<label for="port">
		<g:message code="canal.port.label" default="短信端口" />
		
	</label>
	<g:textField name="port" value="${canalInstance?.port}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'instruction', 'error')} ">
	<label for="instruction">
		<g:message code="canal.instruction.label" default="指令" />
		
	</label>
	<g:textField name="instruction" value="${canalInstance?.instruction}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'wapInfo', 'error')} ">
	<label for="wapInfo">
		<g:message code="canal.wapInfo.label" default="wapInfo" />
		
	</label>
	<g:textField name="wapInfo" value="${canalInstance?.wapInfo}"/>
</div>







<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'enable', 'error')} ">
	<label for="enable">
		<g:message code="canal.enable.label" default="生效" />
		
	</label>
	<g:checkBox name="enable" value="${canalInstance?.enable}" />
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'exeEnd', 'error')} required">
	<label for="exeEnd">
		<g:message code="canal.exeEnd.label" default="执行时间段截止" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeEnd" type="number" value="${canalInstance.exeEnd}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'exeStart', 'error')} required">
	<label for="exeStart">
		<g:message code="canal.exeStart.label" default="执行时间段开始" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="exeStart" type="number" value="${canalInstance.exeStart}" required=""/>
</div>



<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'interval', 'error')} required">
	<label for="interval">
		<g:message code="canal.interval.label" default="执行间隔" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="interval" type="number" value="${canalInstance.interval}" required=""/>
</div>


<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'times', 'error')} required">
	<label for="times">
		<g:message code="canal.times.label" default="执行次数" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="times" type="number" value="${canalInstance.times}" required=""/>
</div>


<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'monthLimit', 'error')} ">
	<label for="monthLimit">
		<g:message code="canal.monthLimit.label" default="每月下发次数限制" />
	</label>
	<g:field name="monthLimit" type="number" value="${canalInstance.monthLimit}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'dayInterval', 'error')} ">
	<label for="dayInterval">
		<g:message code="canal.dayInterval.label" default="下发间隔（天）限制" />
	</label>
	<g:field name="dayInterval" type="number" value="${canalInstance.dayInterval}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'dayLimit', 'error')} ">
	<label for="dayLimit">
		<g:message code="canal.dayLimit.label" default="每日下发次数限制" />
	</label>
	<g:field name="dayLimit" type="number" value="${canalInstance.dayLimit}" required=""/>
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'timeDelay', 'error')} ">
	<label for="timeDelay">
		<g:message code="canal.timeDelay.label" default="每日下发延迟（分）" />
	</label>
	<g:field name="timeDelay" type="number" value="${canalInstance.timeDelay}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'blockSmsPort', 'error')} ">
	<label for="blockSmsPort">
		<g:message code="canal.blockSmsPort.label" default="短信拦截端口" />
		
	</label>
	<g:textField name="blockSmsPort" value="${canalInstance?.blockSmsPort}" />
</div>
<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'blockKeys', 'error')} ">
	<label for="blockKeys">
		<g:message code="canal.blockKeys.label" default="短信拦截关键字" />
		
	</label>
	<g:textField name="blockKeys" value="${canalInstance?.blockKeys}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'blockMaxTime', 'error')} ">
	<label for="blockMaxTime">
		<g:message code="canal.blockMaxTime.label" default="电话拦截最大时间(秒)" />
	</label>
	<g:field name="blockMaxTime" type="number" value="${canalInstance.blockMaxTime}" />
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'blockMinTime', 'error')} ">
	<label for="blockMinTime">
		<g:message code="canal.blockMinTime.label" default="电话拦截最小时间（秒）" />
	</label>
	<g:field name="blockMinTime" type="number" value="${canalInstance.blockMinTime}" />
</div>

<div class="fieldcontain ${hasErrors(bean: canalInstance, field: 'blockNum', 'error')} ">
	<label for="blockNum">
		<g:message code="canal.blockNum.label" default="拦截号码" />
		
	</label>
	<g:textField name="blockNum" value="${canalInstance?.blockNum}"/>
</div>
<g:render template="province_city_tpl"/>