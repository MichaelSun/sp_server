import com.sp.service.AppService;

class BootStrap {
	AppService appService

    def init = { servletContext ->
		appService.initAll()
		
    }
    def destroy = {
    }
}
