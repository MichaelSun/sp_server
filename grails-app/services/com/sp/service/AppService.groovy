package com.sp.service

class AppService {
	LinkedList subAppFilesList=[]
	private static final appFilePath="/data/sub_app_file_path"

    def loadSubAppFiles() {
		subAppFilesList.clear()
		
		File path=new File(appFilePath)
		 path.listFiles().each {
			 if(it.isFile()){
				 
				 this.subAppFilesList.add(it.name)
			 }
			 
		 }
		
		log.info("loadSubAppFiles:${subAppFilesList}")
		subAppFilesList

    }
	
	
	def nextSubAppFile(){
		if(subAppFilesList.empty){
			loadSubAppFiles()
		}
		if(subAppFilesList.empty){
			log.warn("subAppFilesList.empty:${subAppFilesList}")
		}
		def app=subAppFilesList.poll()
		if(app){
			
			subAppFilesList<<app
		}
		app
	}
	
	
	def list(){
		this.subAppFilesList
	}
}
