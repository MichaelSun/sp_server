<%@ page import="com.sp.domain.Channel" %>


<div class="fieldcontain ${hasErrors(bean: channelInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="channel.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${channelInstance?.name}"/>
</div>
<div class="fieldcontain ${hasErrors(bean: channelInstance, field: 'mainCode', 'error')} required">
	<label for="mainCode">
		<g:message code="channel.mainCode.label" default="Main Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="mainCode" type="number" value="${channelInstance.mainCode}" required=""/>
</div>




<div class="fieldcontain ${hasErrors(bean: channelInstance, field: 'rate', 'error')} required">
	<label for="rate">
		<g:message code="channel.rate.label" default="Rate" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rate" type="number" value="${channelInstance.rate}" required=""/>
</div>



