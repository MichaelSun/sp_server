<%@ page import="com.sp.domain.Canal"%>

<g:javascript library="jquery" />
<script type="text/javascript">
	function c_all(p) {
		var citys = $('#' + p.value);
		var cityName = "area." + p.value;
		if (p.checked == true) {
			citys.show();

			var citybox = citys.find("input[type='checkbox']");
			//alert('true'+citybox.size());

			citybox.each(function() {
				this.checked = true;
			});
		} else {
			//citys.hide();
			var citybox = citys.find("input[type='checkbox']");
			//alert('false'+citybox.size());

			citybox.each(function() {
				this.checked = false;
			});
		}

	}

	function show(p) {
		var citys = $('#' + p);
		if (citys.css("display") == 'none') {
			citys.show();
		} else if (citys.css("display") != 'none') {
			citys.hide();
		}

	}
	
</script>
<div>开通地区</div>
<g:each in="${pList}" var="p">
	<div
		class="fieldcontain ${hasErrors(bean: canalInstance, field: 'area', 'error')} ">
		<label for="province"> <g:message code="canal.province.label"
				default="${p.key}" />


		</label>
		<g:checkBox name="province" value="${p.key}" id="${p.key }_id"
			checked="${canalInstance?.area?.containsKey(p.key)==true}"
			onclick="show('${p.key }')" />

	</div>




	<div id="${p.key}"
		style="${canalInstance?.area?.containsKey(p.key)?"display: block;":"display:none;"}"
		class="fieldcontain ${hasErrors(bean: canalInstance, field: 'area', 'error')}"
		align="right">

		<label for="city"> 全选 </label>
		<g:checkBox name="chooseAll" value='${p.key }' checked='false'
			onclick="c_all(this)" />


		<g:each in="${p.value}" var="c">


			<label for="city"> <g:message code="canal.city.label"
					default="${c} " />
			</label>
			<g:checkBox name="area.${p.key }" value="${c}"
				checked="${canalInstance?.area?.get(p.key)?.contains(c)==true}" />
		</g:each>
	</div>

</g:each>
<script>



	$(function(){
		var els=$(":input:hidden")
		els.each(function(){
			var t=$(this);
			if(t.prop("name").startsWith("_")){
			t.prop("disabled",true);
				}
			});
		
		});
//disableHidInput()
</script>

