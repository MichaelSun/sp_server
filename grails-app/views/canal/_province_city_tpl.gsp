<%@ page import="com.sp.domain.Canal"%>


<g:each in="${pList}" var="p">
	<div
		class="fieldcontain ${hasErrors(bean: canalInstance, field: 'area', 'error')} ">
		<label for="province"> <g:message code="canal.province.label"
				default="${p.key} " />
		</label>
		<g:checkBox name="province" value="${p.key}"
			checked="${canalInstance?.province?.contains(p)==true}" />
	</div>
	<div
		class="fieldcontain ${hasErrors(bean: canalInstance, field: 'area', 'error')}" align="right">
		<g:each in="${p.value}" var="c">


			<label for="city"> <g:message code="canal.city.label"
					default="${c} " />
			</label>
			<g:checkBox name="area.${p.key} }" value="${c}"
				checked="${canalInstance?.city?.contains(p)==true}" />
		</g:each>
	</div>

</g:each>

