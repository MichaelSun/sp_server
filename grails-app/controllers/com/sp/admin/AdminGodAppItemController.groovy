package com.sp.admin

import com.sp.domain.GodAppItem

class AdminGodAppItemController {

	
	static allowedMethods = [save: "POST",activate:"POST"]
	
		    def list(Integer max) {
		        params.max = Math.min(max ?: 10, 100)
		        [godAppItemInstanceList: GodAppItem.list(params), godAppItemInstanceTotal: GodAppItem.count()]
		    }
}
