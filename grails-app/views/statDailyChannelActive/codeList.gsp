<%@ page import="com.sp.domain.stat.DailyChannelActive" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="channel_user">
    <g:set var="entityName"
           value="${message(code: 'dailyChannelActive.label', default: 'DailyChannelActive')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-dailyChannelActive" class="skip" tabindex="-1"><g:message
        code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="#"><g:message
                code="default.home.label"/></a></li>
    </ul>
</div>

<div id="list-dailyChannelActive" class="content scaffold-list"
     role="main">
    <h1>
        <g:message code="default.list.label" args="[entityName]"/>
    </h1>

    <g:if test="${flash.message}">
        <div class="message" role="status">
            ${flash.message}
        </div>
    </g:if>
    <g:if test="${msg}">
        <div class="message" role="status">
            ${msg}
        </div>
    </g:if>

    <div class="nav" role="search">
        <ul>
            <g:form action="${code ?: 'NULL'}">

                <li>
                    <fieldset class="form">
                        <g:datePicker name="sdate" value="${datePicker}"
                                      noSelection="['': '-选择-']" precision="month"
                                      years="${2013..2020}"/>
                    </fieldset>
                </li>
                <li>
                    <fieldset class="buttons">
                        <g:submitButton name="search" value="查询"/>
                    </fieldset>
                </li>

            </g:form>
        </ul>
    </div>





    <table>
        <thead>
        <tr>

            <g:sortableColumn property="day"
                              title="${message(code: 'dailyChannelActive.day.label', default: '时间')}"/>

            <g:sortableColumn property="channelCode"
                              title="${message(code: 'dailyChannelActive.channelCode.label', default: '渠道号')}"/>

            <g:sortableColumn property="num"
                              title="${message(code: 'dailyChannelActive.num.label', default: '数量')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${dailyChannelActiveInstanceList}" status="i"
                var="dailyChannelActiveInstance">

            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>
                    ${fieldValue(bean: dailyChannelActiveInstance, field: "day")}
                </td>

                <td>
                    ${fieldValue(bean: dailyChannelActiveInstance, field: "channelCode")}
                </td>


                <td>
                    %{--<sp:rater num="${dailyChannelActiveInstance.num}"--}%
                              %{--rate="${dailyChannelActiveInstance.rate}"></sp:rater>--}%
                    <sp:roundRater rateNum="${dailyChannelActiveInstance.rateNumber}"></sp:roundRater>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        本页总数:
        <sp:rateListNum rate="${dailyChannelActiveInstance?.rate}"
                        rows="${dailyChannelActiveInstanceList}"/>
    </div>
    <%--<div class="pagination">
        <g:paginate total="${dailyChannelActiveInstanceTotal}" />
    </div>
--%>
</div>
</body>
</html>
