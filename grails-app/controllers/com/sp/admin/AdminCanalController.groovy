package com.sp.admin

import org.springframework.dao.DataIntegrityViolationException

import com.sp.domain.Canal

class AdminCanalController {
    def appService
    private static pList = [:]
    static {
        pList['北京'] = ['北京']
        pList['上海'] = ['上海'];
        pList['天津'] = ['天津'];
        pList['重庆'] = ['重庆'];
        pList['香港'] = ['香港'];
        pList['澳门'] = ['澳门'];

        pList['山东'] = [
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
        pList['河北'] = [
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
        pList['山西'] = [
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
        pList['黑龙江'] = [
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
        pList['吉林'] = [
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
        pList['辽宁'] = [
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
        pList['内蒙古'] = [
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
        pList['江苏'] = [
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
        pList['浙江'] = [
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
        pList['安徽'] = [
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
        pList['福建'] = [
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
        pList['江西'] = [
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
        pList['河南'] = [
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
        pList['湖北'] = [
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
        pList['湖南'] = [
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
        pList['广东'] = [
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
        pList['广西'] = [
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
        pList['海南'] = ['海口', '三亚'];
        pList['四川'] = [
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
        pList['贵州'] = [
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
        pList['云南'] = [
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
        pList['西藏'] = [
                '拉萨',
                '日喀则',
                '山南',
                '林芝',
                '昌都',
                '阿里',
                '那曲'
        ];
        pList['陕西'] = [
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
        pList['甘肃'] = [
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
        pList['宁夏'] = ['银川', '石嘴山', '吴忠', '固原'];
        pList['青海'] = [
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
        pList['新疆'] = [
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
        pList['台湾'] = [
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

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [canalInstanceList: Canal.list(params), canalInstanceTotal: Canal.count()]
    }

    def create() {
        [canalInstance: new Canal(params), pList: pList]
    }

    def save() {
        if (params.checkMoneyInfo && !params.checkMoneyInfo.isEmpty()) {
            String cmis = params.checkMoneyInfo as String[]
            println cmis as List
        }

        def canalInstance = new Canal(params)
        //		println canalInstance.properties
        //		println params
        //		canalInstance.code=params.code
        //		println canalInstance.properties
        if (params.province instanceof String) {
            params.province = [params.province]
        }
        def areaProp = [:]
        if (params.province instanceof List || params.province instanceof String[]) {
            params.province.each { p ->
                def citys = params.area[p]
                if (citys instanceof String) {
                    citys = [citys]
                }
                if (citys instanceof List || citys instanceof String[]) {
                    //				citys.each {
                    //					println p+'->'+it
                    //				}
                    def citystr = new StringBuffer();
                    citys.each {
                        if (!citystr.toString().empty) {
                            citystr << ","
                        }
                        citystr << it
                    }
                    areaProp[p] = citystr.toString()
                }
            }
        }
        canalInstance.area = areaProp

        if (!canalInstance.save(flush: true)) {
            render(view: "create", model: [canalInstance: canalInstance, pList: pList])
            return
        }
        appService.loadCanal2AreaMap(canalInstance)

        flash.message = message(code: 'default.created.message', args: [
                message(code: 'canal.label', default: 'Canal'),
                canalInstance.id
        ])
        redirect(action: "show", id: canalInstance.id)


    }

    def show(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [canalInstance: canalInstance]
    }

    def edit(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(action: "list")
            return
        }

        [canalInstance: canalInstance, pList: pList]
    }


    def update(Long id, Long version) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(controller: "adminCanal", action: "list")
            return
        }

        if (version != null) {
            if (canalInstance.version > version) {
                canalInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [
                                message(code: 'canal.label', default: 'Canal')] as Object[],
                        "Another user has updated this Canal while you were editing")
                render(view: "edit", model: [canalInstance: canalInstance])
                return
            }
        }
        appService.clearCanalAreaMapByCanal(canalInstance)

        canalInstance.properties = params
        if (!params.enable) {
            canalInstance.enable = false
        }

        if (params.province instanceof String) {
            params.province = [params.province]
        }
        def areaProp = [:]
        if (params.province instanceof List || params.province instanceof String[]) {
            params.province.each { p ->
                def citys = params.area[p]
                if (citys instanceof String) {
                    citys = [citys]
                }
                if (citys instanceof List || citys instanceof String[]) {
                    //				citys.each {
                    //					println p+'->'+it
                    //				}
                    def citystr = new StringBuffer()
                    citys.each {
                        if (!citystr.toString().empty) {

                            citystr << ","
                        }
                        citystr << it
                    }
                    areaProp[p] = citystr.toString()
                }
            }
        }
        canalInstance.area = areaProp

        if (!canalInstance.save(flush: true)) {
            render(view: "edit", model: [canalInstance: canalInstance])
            return
        }
        appService.loadCanal2AreaMap(canalInstance)

        flash.message = message(code: 'default.updated.message', args: [
                message(code: 'canal.label', default: 'CanalCanal'),
                canalInstance.id
        ])
        redirect(action: "show", id: canalInstance.id)
    }

    def delete(Long id) {
        def canalInstance = Canal.get(id)
        if (!canalInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(action: "list")
            return
        }

        try {
            canalInstance.enable = false
            appService.clearCanalAreaMapByCanal(canalInstance)
            canalInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [
                    message(code: 'canal.label', default: 'Canal'),
                    id
            ])
            redirect(action: "show", id: id)
        }
    }
}
