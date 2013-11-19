package com.sp.admin

import grails.plugin.nimble.core.AdminsService

import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.Subject

class AdminController {

    def index() { 
		
		Subject currentUser = SecurityUtils.subject;
		if(!currentUser||!currentUser.hasRole(AdminsService.ADMIN_ROLE)){
			flash.message="您不具备访问资格"
			redirect uri:'/login'
			return
		}
		
		
	}
}
