<ul class="nav-list" id="dashboard-menu">



	<li><g:link controller="adminChannel" action="list">
				渠道管理</g:link></li>
	<li><g:link controller="adminCanal" action="list">
					通道管理
				</g:link></li>
	<li><g:link url="${createLink(uri:'/adminDailyChannelActive')}">
					渠道统计
				</g:link></li>
	<li><g:link url="${createLink(uri:'/adminDailyCanalActive') }">
					通道统计
				</g:link></li>
	<li><g:link controller="adminGodAppItem" action="list">
					主程序表
				</g:link></li>
	<li><g:link controller="adminSubAppItem" action="list">
					子程序表
				</g:link></li>
	<li><g:link controller="adminSpDomain" action="list">
					域名管理
				</g:link></li>
	<li><g:link controller="adminSubAppFile" action="list">
					子程序文件载入
				</g:link></li>
	<li><g:link controller="adminCityMap" action="index">
					城市配置XML载入
				</g:link></li>
	<li><g:link controller="adminCityMap" action="codeCanalMap">
					通道映射图
				</g:link></li>
	<li><g:link
			url="${createLink(uri:'/administration/adminstrators') }">
					权限管理
				</g:link></li>

</ul>
