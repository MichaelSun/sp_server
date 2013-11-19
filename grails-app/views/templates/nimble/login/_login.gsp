<!doctype html>
<html>
   <head>
      <title>
         <g:message code="nimble.template.login.title" />
      </title>
      <r:script disposition='head'>
         $(function() {
         $(".loginmethod").hide();
         $("#loginfacebookcontinue").hide();
         var active = jQuery.url.param("active")
         if (active) {
         changeLogin(active);
         }
         else {
         changeLogin('local');
         }
         $("#loginlocal").show();
         $(".flash").show();
         $("#username").focus();
         });
      </r:script>
      <r:require modules="nimble-login"/>
      <r:layoutResources/>
   </head>
   <body>
      <div class="login-container">
         <div class="login-content">
            <h2 class="border-bottom">
            请登录
            </h2>          
            <n:flashembed/>  
            <%--<g:if test="${registration}">
               <div class="login-options">
                  <h4>
                     <g:message code="nimble.label.login.signup.heading"/>
                  </h4>
                  <g:message code="nimble.label.login.signup.descriptive"/>
                  <g:link controller="account" action="createuser">
                     <g:message code="nimble.link.login.signup"/>
                  </g:link>
               </div>
               <div style="text-align: center; margin-bottom: 3px;">-- OR --</div>
            </g:if>
            --%><g:form action="signin" name="login-form" method="post">
               <div class="login-input">
                  <div class="control-group">
                     <div class="controls ">
                        <input type="hidden" name="targetUri" value="${targetUri}"/>
                        <input type="text" name="username" id="username" placeholder="user@example.com">                           
                     </div>
                  </div>
                  <div class="control-group">
                     <div class="controls">
                        <input type="password" name="password" id="password" placeholder="password">
                     </div>
                  </div>
               </div>
               <div class="login-actions">
                  <label class="checkbox" style="display: inline-block;">
                     <input type="checkbox" name="rememberme">
                     保持登录
                  </label>
                  <span class="pull-right clearfix">
                     <button type="submit" class="btn btn-primary">
                        登录
                     </button>
                  </span>
               </div>
               <%--<div class="login-options border-top">
                  <h4>
                     <g:message code="nimble.label.login.forgottenpassword.heading" />
                  </h4>                  
                  <g:message code="nimble.label.login.forgottenpassword.descriptive" />
                  <g:link controller="account" action="forgottenpassword" style="text-transform:lowercase;">
                     <g:message code="nimble.link.resetpassword" />
                  </g:link>
               </div>
            --%></g:form>
         </div>
      </div>
      <r:layoutResources/>
   </body>
</html>