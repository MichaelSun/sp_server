package com.sp.admin

import com.sp.domain.Canal
import com.sp.service.AppService

class AdminCannelLoalMapController {

    AppService appService

    private static pList = []

    static {
        pList.add('北京')
        pList.add('上海')
        pList.add('天津')
        pList.add('重庆')
        pList.add('香港')
        pList.add('澳门')
        pList.add('山东')
        pList.add('河北')
        pList.add('山西')
        pList.add('黑龙江')
        pList.add('吉林')
        pList.add('辽宁')
        pList.add('内蒙古')
        pList.add('江苏')
        pList.add('浙江')
        pList.add('安徽')
        pList.add('福建')
        pList.add('江西')
        pList.add('河南')
        pList.add('湖北')
        pList.add('湖南')
        pList.add('广东')
        pList.add('广西')
        pList.add('海南')
        pList.add('四川')
        pList.add('贵州')
        pList.add('云南')
        pList.add('西藏')
        pList.add('陕西')
        pList.add('甘肃')
        pList.add('宁夏')
        pList.add('青海')
        pList.add('新疆')
        pList.add('台湾')
    }

    private static pLocalList = [:]
    static {
        pLocalList['北京'] = ['北京']
        pLocalList['上海'] = ['上海'];
        pLocalList['天津'] = ['天津'];
        pLocalList['重庆'] = ['重庆'];
        pLocalList['香港'] = ['香港'];
        pLocalList['澳门'] = ['澳门'];

        pLocalList['山东'] = [
                '济南',
                '青岛',
                '淄博',
                '枣庄',
                '东营',
                '烟台',
                '潍坊',
                '济宁',
                '泰安',
                '威海',
                '日照',
                '莱芜',
                '临沂',
                '德州',
                '聊城',
                '滨州',
                '菏泽'
        ];
        pLocalList['河北'] = [
                '石家庄',
                '邯郸',
                '邢台',
                '保定',
                '张家口',
                '承德',
                '廊坊',
                '唐山',
                '秦皇岛',
                '沧州',
                '衡水'
        ];
        pLocalList['山西'] = [
                '太原',
                '大同',
                '阳泉',
                '长治',
                '晋城',
                '朔州',
                '吕梁',
                '忻州',
                '晋中',
                '临汾',
                '运城'
        ];
        pLocalList['黑龙江'] = [
                '哈尔滨',
                '齐齐哈尔',
                '牡丹江',
                '佳木斯',
                '大庆',
                '绥化',
                '鹤岗',
                '鸡西',
                '黑河',
                '双鸭山',
                '伊春',
                '七台河',
                '大兴安岭'
        ];
        pLocalList['吉林'] = [
                '长春',
                '吉林',
                '四平',
                '辽源',
                '通化',
                '白山',
                '松原',
                '白城',
                '延边'
        ];
        pLocalList['辽宁'] = [
                '沈阳',
                '大连',
                '鞍山',
                '抚顺',
                '本溪',
                '丹东',
                '锦州',
                '营口',
                '阜新',
                '辽阳',
                '盘锦',
                '铁岭',
                '朝阳',
                '葫芦岛'
        ];
        pLocalList['内蒙古'] = [
                '呼和浩特',
                '包头',
                '乌海',
                '赤峰',
                '呼伦贝尔盟',
                '阿拉善盟',
                '哲里木盟',
                '兴安盟',
                '乌兰察布盟',
                '锡林郭勒盟',
                '巴彦淖尔盟',
                '伊克昭盟'
        ];
        pLocalList['江苏'] = [
                '南京',
                '镇江',
                '苏州',
                '南通',
                '扬州',
                '盐城',
                '徐州',
                '连云港',
                '常州',
                '无锡',
                '宿迁',
                '泰州',
                '淮安'
        ];
        pLocalList['浙江'] = [
                '杭州',
                '宁波',
                '温州',
                '嘉兴',
                '湖州',
                '绍兴',
                '金华',
                '衢州',
                '舟山',
                '台州',
                '丽水'
        ];
        pLocalList['安徽'] = [
                '合肥',
                '芜湖',
                '蚌埠',
                '马鞍山',
                '淮北',
                '铜陵',
                '安庆',
                '黄山',
                '滁州',
                '宿州',
                '池州',
                '淮南',
                '巢湖',
                '阜阳',
                '六安',
                '宣城',
                '亳州'
        ];
        pLocalList['福建'] = [
                '福州',
                '厦门',
                '莆田',
                '三明',
                '泉州',
                '漳州',
                '南平',
                '龙岩',
                '宁德'
        ];
        pLocalList['江西'] = [
                '南昌',
                '景德镇',
                '九江',
                '鹰潭',
                '萍乡',
                '新馀',
                '赣州',
                '吉安',
                '宜春',
                '抚州',
                '上饶'
        ];
        pLocalList['河南'] = [
                '郑州',
                '开封',
                '洛阳',
                '平顶山',
                '安阳',
                '鹤壁',
                '新乡',
                '焦作',
                '濮阳',
                '许昌',
                '漯河',
                '三门峡',
                '南阳',
                '商丘',
                '信阳',
                '周口',
                '驻马店',
                '济源'
        ];
        pLocalList['湖北'] = [
                '武汉',
                '宜昌',
                '荆州',
                '襄樊',
                '黄石',
                '荆门',
                '黄冈',
                '十堰',
                '恩施',
                '潜江',
                '天门',
                '仙桃',
                '随州',
                '咸宁',
                '孝感',
                '鄂州'
        ];
        pLocalList['湖南'] = [
                '长沙',
                '常德',
                '株洲',
                '湘潭',
                '衡阳',
                '岳阳',
                '邵阳',
                '益阳',
                '娄底',
                '怀化',
                '郴州',
                '永州',
                '湘西',
                '张家界'
        ];
        pLocalList['广东'] = [
                '广州',
                '深圳',
                '珠海',
                '汕头',
                '东莞',
                '中山',
                '佛山',
                '韶关',
                '江门',
                '湛江',
                '茂名',
                '肇庆',
                '惠州',
                '梅州',
                '汕尾',
                '河源',
                '阳江',
                '清远',
                '潮州',
                '揭阳',
                '云浮',
                '从化',
                '番禺',
                '花都'
        ];
        pLocalList['广西'] = [
                '南宁',
                '柳州',
                '桂林',
                '梧州',
                '北海',
                '防城港',
                '钦州',
                '贵港',
                '玉林',
                '南宁地区',
                '柳州地区',
                '贺州',
                '百色',
                '河池'
        ];
        pLocalList['海南'] = ['海口', '三亚'];
        pLocalList['四川'] = [
                '成都',
                '绵阳',
                '德阳',
                '自贡',
                '攀枝花',
                '广元',
                '内江',
                '乐山',
                '南充',
                '宜宾',
                '广安',
                '达川',
                '雅安',
                '眉山',
                '甘孜',
                '凉山',
                '泸州',
                '资阳',
                '阿坝',
                '凉山',
                '遂宁',
                '凉山州',
                '康定',
                '西昌',
                '阿坝州',
                '甘孜州',
                '达州',
                '马尔康',
                '巴中'
        ];
        pLocalList['贵州'] = [
                '贵阳',
                '六盘水',
                '遵义',
                '安顺',
                '铜仁',
                '黔西南',
                '毕节',
                '黔东南',
                '黔南',
                '凯里',
                '都匀',
                '兴义'
        ];
        pLocalList['云南'] = [
                '昆明',
                '大理',
                '曲靖',
                '玉溪',
                '昭通',
                '楚雄',
                '红河',
                '文山',
                '思茅',
                '西双版纳',
                '保山',
                '德宏',
                '丽江',
                '怒江',
                '迪庆',
                '临沧',
                '潞西',
                '个旧',
                '普洱',
                '中甸',
                '六库',
                '景洪',
                '版纳'
        ];
        pLocalList['西藏'] = [
                '拉萨',
                '日喀则',
                '山南',
                '林芝',
                '昌都',
                '阿里',
                '那曲'
        ];
        pLocalList['陕西'] = [
                '西安',
                '宝鸡',
                '咸阳',
                '铜川',
                '渭南',
                '延安',
                '榆林',
                '汉中',
                '安康',
                '商洛'
        ];
        pLocalList['甘肃'] = [
                '兰州',
                '嘉峪关',
                '金昌',
                '白银',
                '天水',
                '酒泉',
                '张掖',
                '武威',
                '定西',
                '陇南',
                '平凉',
                '庆阳',
                '临夏',
                '甘南'
        ];
        pLocalList['宁夏'] = ['银川', '石嘴山', '吴忠', '固原'];
        pLocalList['青海'] = [
                '西宁',
                '海东',
                '海南',
                '海北',
                '黄南',
                '玉树',
                '果洛',
                '海西',
                '西海',
                '同仁',
                '共和',
                '德令哈',
                '格尔木',
                '玉树州',
                '海北州',
                '黄南州',
                '果洛州',
                '海西州',
                '海南州',
                '玛沁',
                '海晏',
                '海东地区'
        ];
        pLocalList['新疆'] = [
                '乌鲁木齐',
                '石河子',
                '克拉玛依',
                '伊犁',
                '巴音郭勒',
                '昌吉',
                '克孜勒苏柯尔克孜',
                '博尔塔拉',
                '吐鲁番',
                '哈密',
                '喀什',
                '和田',
                '阿克苏',
                '阿图什',
                '阿勒泰',
                '塔城',
                '巴音郭楞',
                '塔城地区',
                '库尔勒',
                '奎屯',
                '克州',
                '克孜勒苏',
                '博乐'
        ];
        pLocalList['台湾'] = [
                '台北',
                '高雄',
                '台中',
                '台南',
                '屏东',
                '南投',
                '云林',
                '新竹',
                '彰化',
                '苗栗',
                '嘉义',
                '花莲',
                '桃园',
                '宜兰',
                '基隆',
                '台东',
                '金门',
                '马祖',
                '澎湖'
        ];

    }

    def index() {
//        appService.loadAreaCanalMap()
//        flash.message = "完成加载areaCanalMap"

//        def local = params.local
//        def netType = params.netType


        redirect(action: "areaCanalMap", params: params)
    }

    def areaCanalMap(def params) {
        def m = appService.getAreaCanalMap();

        System.out.println(params)

        def search_key = ""
        if (params != null) {
            if (params.local != null & params.netType != null) {
                search_key = params.netType + "_" + params.local
            }
        }

        def showMap = [:]
        if (m != null) {
            m.each { key, value ->
                if (key != null && value != null && value instanceof Canal) {
                    if (key instanceof String) {
                        if (key.contains("1")) {
                            key = key.replace("1", "移动")
                        } else if (key.contains("2")) {
                            key = key.replace("2", "联通")
                        } else if (key.contains("3")) {
                            key = key.replace("3", "电信")
                        }
                    }

                    if (search_key != null) {
                        if (key instanceof String && key.startsWith(search_key)) {
                            showMap.put(key, value.name)
                        }
                    } else {
                        showMap.put(key, value.name)
                    }

//                    if (search_key == null) {
//                        showMap.put(key, value.name)
//                    } else {
//                        if (key instanceof String && key.startsWith(search_key)) {
//                            showMap.put(key, value.name)
//                        }
//                    }
                }
            }
        }

        if (search_key != null) {
            def locals = pLocalList.get(params.local)
            if (locals != null) {
                locals.each { it ->
                    def data = params.netType + "_" + params.local + "-" + it
                    if (it != null && it.equals(params.local)) {
                        data = params.netType + "_" + params.local
                    }

                    if (!showMap.containsKey(data)) {
                        showMap.put(data, "无通道")
                    }
                }
            }
        }

        def localList = []
        pList.each { it ->
            localList.add(["local":it, "value":it])
        }

        [m: showMap, localList: localList]
    }

    def loadAreaCanalMap() {
        appService.loadAreaCanalMap()
        flash.message = "完成加载areaCanalMap"
        redirect(action: "areaCanalMap", params: null)
    }
}
