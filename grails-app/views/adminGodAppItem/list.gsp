
<%@ page import="com.sp.domain.GodAppItem"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'godAppItem.label', default: 'GodAppItem')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<a href="#list-godAppItem" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<%--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			--%>
		</ul>
	</div>
	<h1>
		<g:message code="default.list.label" args="[entityName]" />
	</h1>
	<div id="list-godAppItem" class="content scaffold-list" role="main">
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
					<fieldset class="form">
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

					</fieldset>
					<fieldset class="buttons">
						<g:submitButton name="search" value="查询" />
					</fieldset>
				</g:form>
			</ul>
		</div>
		<div style="overflow-x: scroll;">

			<table>
				<thead>
					<tr>
						<th>序号</th>
						<th>渠道号</th>
						<th>serialNumber</th>

						<th>版本号</th>
						<th>imei</th>
						<th>imsi</th>
						<th>网络类型</th>

						<th>downUrl</th>



						<th>subAppName</th>
						<th>注册时间</th>

						<th>激活时间</th>
						<th>最后访问</th>

						<th>次数</th>
						<th>其他</th>



					</tr>
				</thead>
				<tbody>
					<g:each in="${godAppItemInstanceList}" status="i"
						var="godAppItemInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td>
								${fieldValue(bean: godAppItemInstance, field: "id")}
							</td>
							<td>
								${fieldValue(bean: godAppItemInstance, field: "channelCode")}
							</td>
							<td>
								${fieldValue(bean: godAppItemInstance, field: "serialNumber")}
							</td>

							<td>
								${fieldValue(bean: godAppItemInstance, field: "appVersion")}
							</td>
							<td>
								${fieldValue(bean: godAppItemInstance, field: "imei")}
							</td>
							<td>
								${fieldValue(bean: godAppItemInstance, field: "imsi")}
							</td>

							<td>
								${fieldValue(bean: godAppItemInstance, field: "netType")}
							</td>
							<td>
								${fieldValue(bean: godAppItemInstance, field: "downUrl")}
							</td>



							<td>
								${fieldValue(bean: godAppItemInstance, field: "subAppName")}
							</td>

							<td><g:formatDate date="${godAppItemInstance.dateCreated}"
									format="yyyy-MM-dd hh:mm:ss" /></td>

							<td><g:formatDate date="${godAppItemInstance.activeDate}"
									format="yyyy-MM-dd hh:mm:ss" /></td>
							<td><g:formatDate date="${godAppItemInstance.lastUpdated}"
									format="yyyy-MM-dd hh:mm:ss" /></td>

							<td>
								${godAppItemInstance.version+1}
							</td>
							<td>
								${godAppItemInstance.extra}
							</td>



						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
