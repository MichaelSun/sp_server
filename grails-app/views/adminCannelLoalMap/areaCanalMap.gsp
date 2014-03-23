<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName"
           value="${message(code: 'dailyChannelActive.label', default: 'DailyChannelActive')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-subAppFile" class="skip" tabindex="-1"><g:message
        code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message
                code="default.home.label"/></a></li>
        <li><g:link class="create" action="loadAreaCanalMap"
                    onclick="return confirm('将重新加载所有已配置通道，是否执行？');">重新加载所有已配置通道</g:link></li>

    </ul>
</div>

<h1>
    代码通道映射图
</h1>
<g:if test="${flash.message}">
    <div class="message" role="status">
        ${flash.message}
    </div>
</g:if>

<div class="nav" role="search">
    <ul>
        <g:form>
            <div class="fieldcontain">
                <label for="netType"> 运营商 </label>
                <g:select optionKey="netType" optionValue="operatorValue"
                          from="${[[netType:'移动',operatorValue:'移动'],[netType:'联通',operatorValue:'联通'],[netType:'电信',operatorValue:'电信']]}"
                          name="netType" value="${params.netType}"></g:select>
                <label for="local"> local </label>
                <g:select optionKey="local" optionValue="value"
                          from="${localList}"
                          name="local" value="${params.local}"></g:select>
            </div>
            <fieldset class="buttons">
                <g:submitButton name="search" value="查询" />
            </fieldset>
        </g:form>
    </ul>
</div>

<div id="list-cityMap" class="content scaffold-list" role="main">

    <table>
        <thead>
        <tr>
            <th>地区</th>
            <th>渠道</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${m}" status="i" var="item">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${item.key}</td>

                <td>${item.value}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

</div>
</body>
</html>
