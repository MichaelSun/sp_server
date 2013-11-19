<ul  class="nav nav-list" id="dashboard-menu">
   <!--  
   <li class="nav-header">
      <i class="icon-home"></i>
      <span><g:message code="nimble.template.sidenavigation.heading" /></span>
   </li>
   -->
   <li>
      <g:link controller="admins" action="index">
         <i class="icon-home"></i>
         <span>管理员表</span>       
                                      
      </g:link>
   </li>      
   <li>       
      <g:link controller="user" action="list">
         <i class="icon-home"></i>
         <span>用户表</span>
      </g:link>
      
   </li>
   <li>
      <g:link controller="role" action="list">
         <i class="icon-home"></i>
         <span>角色表</span>      
      </g:link>
   </li>
   <li>
      <g:link controller="group" action="list">
         <i class="icon-home"></i>
         <span>群组表</span>                     
      </g:link>
   </li>
</ul>