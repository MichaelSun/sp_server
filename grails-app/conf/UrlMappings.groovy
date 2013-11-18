class UrlMappings {

	static mappings = {
		
		
		
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"/index"(view:"/index_bak")
		"500"(view:'/error')
		
		"/gais/"(controller: "godAppItem", action: "save")
		
		"/gais/$serialNumber/"(controller: "godAppItem", action: "activate")
		
		
		"/sais/"(controller: "subAppItem", action: "save")
		
		"/statDailyChannelActive/$code"(controller: "statDailyChannelActive", action: "codeList")
		"/adminDailyChannelActive/$code"(controller: "adminDailyChannelActive", action: "list")
		
		"/adminDailyCanalActive/$canalName"(controller: "adminDailyCanalActive", action: "list")
	
		"/adminSubAppFile/load/" (controller: "adminSubAppFile", action: "load")
		//"/adminCityMap/loadCodeCanalMap/" (controller: "adminCityMap", action: "loadCodeCanalMap")
		
		
		
		
	}
}
