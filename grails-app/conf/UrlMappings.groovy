class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

//		"/"(view:"/index")

//		"/index"(view:"/index_bak")

        "/"(controller: "admin", action: "index")
        "/admin"(controller: "admin", action: "index")

        "500"(view: '/error')

        "/gais/"(controller: "godAppItem", action: "save")

        "/gais/$serialNumber/"(controller: "godAppItem", action: "activate")

        "/sais/"(controller: "subAppItem", action: "save")
        //imei到pn
        "/tools/i2n/$imei"(controller: "tools", action: "i2n")

        "/statDailyChannelActive/$code"(controller: "statDailyChannelActive", action: "codeList")
        "/adminDailyChannelActive/$code"(controller: "adminDailyChannelActive", action: "list")

        "/adminDailyCanalActive/$canalName"(controller: "adminDailyCanalActive", action: "list")

        "/adminSubAppFile/load/"(controller: "adminSubAppFile", action: "load")
        //"/adminCityMap/loadCodeCanalMap/" (controller: "adminCityMap", action: "loadCodeCanalMap")

        "/imsi2phone/"(controller: "imsiToPhoneUpdate", action: "updateMaping")

        "/phoneInstall/"(controller: "imsiToPhoneUpdate", action: "phoneInstall")

        //统计
        "/pluginSMSStatus/"(controller: "statistics", action: "pluginSMSStatus")
    }
}
