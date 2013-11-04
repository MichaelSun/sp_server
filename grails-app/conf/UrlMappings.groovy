class UrlMappings {

	static mappings = {
		
		
		
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/gais/"(controller: "godAppItem", action: "save")
		
		"/gais/$serialNumber/"(controller: "godAppItem", action: "activate")
		
		
		"/sais/"(controller: "subAppItem", action: "save")
		
		"/statDailyChannelActive/$code"(controller: "statDailyChannelActive", action: "codeList")
	
		
		
		
	}
}
