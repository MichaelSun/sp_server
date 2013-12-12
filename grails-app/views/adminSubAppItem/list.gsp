
<%@ page import="com.sp.domain.SubAppItem"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'subAppItem.label', default: 'SubAppItem')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-subAppItem" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>

		</ul>
	</div>
	<h1>
		<g:message code="default.list.label" args="[entityName]" />
	</h1>
	<div id="list-subAppItem" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>

		<g:if test="${errorInfo}">
			<div class="message" role="status">
				${errorInfo}
			</div>
		</g:if>
		<div class="nav" role="search">
			<ul>
				<g:form>

					<%--<li>
						<fieldset class="form">
							<g:datePicker name="sdate" value="${datePicker}"
								noSelection="['':'-选择-']" precision="month"
								years="${2013..2020}" />
						</fieldset>
					</li>
					--%>
					<div class="fieldcontain">

						<label for="sdate">注册时间起始 </label>

						<g:datePicker name="csDate" value="${params.csDate}"
							noSelection="['':'-选择-']" precision="day" years="${2013..2020}" />
					</div>
					<div class="fieldcontain">

						<label for="sdate">注册时间结束 </label>

						<g:datePicker name="ceDate" value="${params.ceDate}"
							noSelection="['':'-选择-']" precision="day" years="${2013..2020}" />
					</div>
					<div class="fieldcontain">

						<label for="sdate">访问时间起始 </label>

						<g:datePicker name="vsDate" value="${params.vsDate}"
							noSelection="['':'-选择-']" precision="day" years="${2013..2020}" />
					</div>
					<div class="fieldcontain">

						<label for="sdate">访问时间结束 </label>

						<g:datePicker name="veDate" value="${params.veDate}"
							noSelection="['':'-选择-']" precision="day" years="${2013..2020}" />
					</div>

					<div class="fieldcontain">
						<label for="netType"> netType </label>
						<g:select optionKey="netType" optionValue="operatorValue"
							from="${[[netType:'0',operatorValue:'-选择-'],[netType:'1',operatorValue:'移动'],[netType:'2',operatorValue:'联通'],[netType:'3',operatorValue:'电信']]}"
							name="netType" value="${params.netType}"></g:select>
					</div>

					<%--<div class="fieldcontain">
							<label for="imei"> imei </label>
							<g:textField name="imei" />
						</div>
						<div class="fieldcontain">
							<label for="imsi"> imsi </label>
							<g:textField name="imsi" />
						</div>
						<div class="fieldcontain">
							<label for="phoneNumber"> phoneNumber </label>
							<g:textField name="phoneNumber" />
						</div>
						--%>
					<div class="fieldcontain">
						<label for="channelCode"> channelCode </label>
						<g:textField name="channelCode" value="${params.channelCode }" />
					</div>
					<div class="fieldcontain">
						<label for="appVersion"> appVersion </label>
						<g:textField name="appVersion" value="${params.appVersion }" />
					</div>
					<fieldset class="buttons">
						<g:submitButton name="search" value="查询" />
					</fieldset>
				</g:form>
			</ul>
		</div>
		<div style="overflow-x: scroll;">
			<table style="overflow-x: scroll;">
				<thead>
					<tr>
						<th class="sortable">序号</th>
						<th>渠道号</th>


						<th>版本号</th>
						<th>imei</th>
						<th>imsi</th>
						<th>serialNumber</th>
						<th>网络类型</th>


						<th>手机型号</th>
						<th>os版本号</th>

						<th>注册日期</th>
						<th>访问日期</th>
						<th>访问次数</th>
						<th>错误信息</th>


					</tr>
				</thead>
				<tbody>
					<g:each in="${subAppItemInstanceList}" status="i"
						var="subAppItemInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td>
								${fieldValue(bean: subAppItemInstance, field: "id")}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "channelCode")}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "appVersion")}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "imei")}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "imsi")}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "serialNumber")}
							</td>
							<td><sp:opName
									operator="${fieldValue(bean: subAppItemInstance, field: "netType")}" />
							</td>

							
							<td>
								${fieldValue(bean: subAppItemInstance, field: "phoneType")}
							</td>




							<td>
								${fieldValue(bean: subAppItemInstance, field: "osVersion")}
							</td>

							<td><g:formatDate date="${subAppItemInstance.dateCreated}"
									format="yyyy/MM/dd hh:mm:ss" /></td>

							<td><g:formatDate date="${subAppItemInstance.lastUpdated}"
									format="yyyy/MM/dd hh:mm:ss" /></td>
							<td>
								${subAppItemInstance.version+1}
							</td>
							<td>
								${fieldValue(bean: subAppItemInstance, field: "error")}
							</td>

						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
		<%--<div class="pagination">
			<g:paginate total="${subAppItemInstanceTotal}" />
		</div>
	--%>
	</div>
</body>
</html>
