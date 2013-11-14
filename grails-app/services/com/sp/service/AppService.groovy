package com.sp.service

import org.apache.log4j.chainsaw.LoadXMLAction;

import com.sp.domain.Canal
import com.xstd.plugin.Utils.XMLTables
import com.xstd.plugin.Utils.XMLTables.LocationInfo

class AppService {

	Map codeCanalMap=[:]//要求启动加载



	LinkedList subAppFilesList=[]//要求启动加载
	private static final appFilePath="/data/sub_app_file_path"


	private static final cityXmlFilePath="/data/city_xml_file_path/city_map.xml"
	private XMLTables tables//要求启动加载或者直接就初始化，此处直接初始化
	
	def initAll(){
		loadSubAppFiles()
		this.loadCityMap()
		this.loadCodeCanalMap()//canalmap依赖于上一步的cityMap
	}

	
	/**
	 * 全部加载短信中心代码到通道的映射
	 * @return
	 */
	def loadCodeCanalMap(){
		if(!this.subAppFilesList||subAppFilesList.size()==0){
			this.loadSubAppFiles();
		}
		def canalList=Canal.list()
		canalList.each {Canal canal->
			loadCanal2CodeCanalMap(canal);
		}
		log.info("loadCodeCanalMap:${codeCanalMap}")
	}

	/**
	 * 当canal变化,新增的时候，刷新短信中心代码到通道的映射
	 * @param canal
	 * @return
	 */
	public loadCanal2CodeCanalMap(canal){
		if(!canal||!canal.enable||!canal.area||canal.area.empty){
			return
		}

			canal.area.each {p,citys->
				if(citys){
					String[] cityArr=citys.split(",")
					if(cityArr&&cityArr.length>0){
						cityArr.each {c->

						def p_city=p+c
							if(p==c){
								p_city=p
							}
							List<LocationInfo> lis= this.getLocationInfoByLocaitonName(p_city)
							if(lis&&!lis.isEmpty()){
								lis.each {info->
									codeCanalMap[info.center]=canal
									log.info("codeCanalMap[${info.center}]=${canal}")
								}
							}
						}
					}
				}
			}
	}



	def loadCityMap(){
		if(tables){
			
			tables.clear()
			tables=null
		}
		tables=new XMLTables(cityXmlFilePath);
		log.info("load city map:"+tables.toString())
	}


	public List<LocationInfo> getLocationInfoByOperatorAndCenter(int operator, String center) {
		tables.getLocationInfoByOperatorAndCenter(operator, center)
	}

	//	public List<LocationInfo> getLocationInfoByLocationNumber(int locationNum) {
	//		tables.getLocationInfoByLocationNumber(locationNum)
	//	}

	public List<LocationInfo> getLocationInfoByLocaitonName(String locationName) {
		tables.getLocationInfoByLocaitonName(locationName)
	}



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


	def subAppFilesList(){
		this.subAppFilesList
	}
	
	
	def getCanalByCode(code){
		
		this.codeCanalMap.get(code);
	}
	
	def getCodeCanalMap(){
		this.codeCanalMap
	}
	
	
	def getCheckMoneyInfo(subAppItemInstance,canal){
		
		
		if(canal.checkMoneyThreshold>-1){
			def locationInfo=this.getLocationInfoByOperatorAndCenter(subAppItemInstance.netType ,subAppItemInstance.smsCenter)
			def checkMoneyInfo=new StringBuffer()
			if(locationInfo&&locationInfo.size>0){
				def info=locationInfo[0]
				if(info.checkTarget&&info.checkCmd){
					
					checkMoneyInfo<<info.checkTarget
					checkMoneyInfo<<","
					checkMoneyInfo<<info.checkCmd
					checkMoneyInfo<<","
//						checkMoneyInfo<<info.key
					checkMoneyInfo<<","
					checkMoneyInfo<<canal.checkMoneyThreshold
					return checkMoneyInfo
				}
			}
		}
		
	}
	
	
	
	def getCityMap(){
		
		tables.toString()
	}
	
	
}
