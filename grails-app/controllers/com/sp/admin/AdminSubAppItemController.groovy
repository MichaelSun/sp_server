package com.sp.admin

import com.sp.domain.SubAppItem

class AdminSubAppItemController {

	
	static allowedMethods = [save: "POST",activate:"POST"]
	
		    def list(Integer max) {
		        params.max = Math.min(max ?: 10, 100)
		        [subAppItemInstanceList: SubAppItem.list(params), subAppItemInstanceTotal: SubAppItem.count()]
		    }
}
