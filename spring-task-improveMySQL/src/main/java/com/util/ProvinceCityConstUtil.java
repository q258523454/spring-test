package com.util;

import java.util.*;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-20
 */

public class ProvinceCityConstUtil {
    public static List<String> beiJingCityList = new ArrayList<>();
    public static List<String> tianJingCityList = new ArrayList<>();
    public static List<String> shangHaiCityList = new ArrayList<>();
    public static List<String> chongQingCityList = new ArrayList<>();
    public static List<String> heBeiCityList = new ArrayList<>();
    public static List<String> shanXiCityList = new ArrayList<>();
    public static List<String> neiMengGuCityList = new ArrayList<>();
    public static List<String> liaoNingCityList = new ArrayList<>();
    public static List<String> jiLinCityList = new ArrayList<>();
    public static List<String> heiLongJiangCityList = new ArrayList<>();
    public static List<String> jiangSuCityList = new ArrayList<>();
    public static List<String> zheJiangCityList = new ArrayList<>();
    public static List<String> anHuiCityList = new ArrayList<>();
    public static List<String> fuJianCityList = new ArrayList<>();
    public static List<String> jiangXiCityList = new ArrayList<>();
    public static List<String> shanDongCityList = new ArrayList<>();
    public static List<String> heNanCityList = new ArrayList<>();
    public static List<String> huBeiCityList = new ArrayList<>();
    public static List<String> huNanCityList = new ArrayList<>();
    public static List<String> guangDongCityList = new ArrayList<>();
    public static List<String> guangXiCityList = new ArrayList<>();
    public static List<String> haiNanCityList = new ArrayList<>();
    public static List<String> siChuanCityList = new ArrayList<>();
    public static List<String> guiZhouCityList = new ArrayList<>();
    public static List<String> yunNanCityList = new ArrayList<>();
    public static List<String> xiZangCityList = new ArrayList<>();
    public static List<String> shaanXiCityList = new ArrayList<>();
    public static List<String> ganSuCityList = new ArrayList<>();
    public static List<String> qingHaiCityList = new ArrayList<>();
    public static List<String> ningXiaCityList = new ArrayList<>();
    public static List<String> xinJiangCityList = new ArrayList<>();
    public static List<String> taiWanCityList = new ArrayList<>();
    public static List<String> xiangGangCityList = new ArrayList<>();
    public static List<String> aoMenCityList = new ArrayList<>();

    public static Map<String, List<String>> provinceCityMap = new LinkedHashMap<>();

    static {
        beiJingCityList = new ArrayList<>(Arrays.asList("北京市"));
        shangHaiCityList = new ArrayList<>(Arrays.asList("上海市"));
        tianJingCityList = new ArrayList<>(Arrays.asList("天津市"));
        chongQingCityList = new ArrayList<>(Arrays.asList("重庆市"));
        taiWanCityList = new ArrayList<>(Arrays.asList("台湾省"));
        xiangGangCityList = new ArrayList<>(Arrays.asList("香港"));
        aoMenCityList = new ArrayList<>(Arrays.asList("澳门"));

        heBeiCityList = new ArrayList<>(Arrays.asList("石家庄市", "唐山市", "秦皇岛市", "邯郸市", "邢台市", "保定市", "张家口市", "承德市", "沧州市", "廊坊市", "衡水市"));
        shanXiCityList = new ArrayList<>(Arrays.asList("太原市", "大同市", "阳泉市", "长治市", "晋城市", "朔州市", "晋中市", "运城市", "忻州市", "临汾市", "吕梁市"));
        neiMengGuCityList = new ArrayList<>(Arrays.asList("呼和浩特市", "包头市", "乌海市", "赤峰市", "通辽市", "鄂尔多斯市", "呼伦贝尔市", "巴彦淖尔市", "乌兰察布市", "兴安盟", "锡林郭勒盟", "阿拉善盟"));
        liaoNingCityList = new ArrayList<>(Arrays.asList("沈阳市", "大连市", "鞍山市", "抚顺市", "本溪市", "丹东市", "锦州市", "营口市", "阜新市", "辽阳市", "盘锦市", "铁岭市", "朝阳市", "葫芦岛市"));
        jiLinCityList = new ArrayList<>(Arrays.asList("长春市", "吉林市", "四平市", "辽源市", "通化市", "白山市", "松原市", "白城市", "延边朝鲜族自治州"));
        heiLongJiangCityList = new ArrayList<>(Arrays.asList("哈尔滨市", "齐齐哈尔市", "鸡西市", "鹤岗市", "双鸭山市", "大庆市", "伊春市", "佳木斯市", "七台河市", "牡丹江市", "黑河市", "绥化市", "大兴安岭地区"));
        jiangSuCityList = new ArrayList<>(Arrays.asList("南京市", "无锡市", "徐州市", "常州市", "苏州市", "南通市", "连云港市", "淮安市", "盐城市", "扬州市", "镇江市", "泰州市", "宿迁市"));
        zheJiangCityList = new ArrayList<>(Arrays.asList("杭州市", "宁波市", "温州市", "嘉兴市", "湖州市", "绍兴市", "金华市", "衢州市", "舟山市", "台州市", "丽水市"));
        anHuiCityList = new ArrayList<>(Arrays.asList("合肥市", "芜湖市", "蚌埠市", "淮南市", "马鞍山市", "淮北市", "铜陵市", "安庆市", "黄山市", "滁州市", "阜阳市", "宿州市", "六安市", "亳州市", "池州市", "宣城市"));
        fuJianCityList = new ArrayList<>(Arrays.asList("福州市", "厦门市", "莆田市", "三明市", "泉州市", "漳州市", "南平市", "龙岩市", "宁德市"));
        jiangXiCityList = new ArrayList<>(Arrays.asList("南昌市", "景德镇市", "萍乡市", "九江市", "新余市", "鹰潭市", "赣州市", "吉安市", "宜春市", "抚州市", "上饶市"));
        shanDongCityList = new ArrayList<>(Arrays.asList("济南市", "青岛市", "淄博市", "枣庄市", "东营市", "烟台市", "潍坊市", "济宁市", "泰安市", "威海市", "日照市", "莱芜市", "临沂市", "德州市", "聊城市", "滨州市", "菏泽市"));
        heNanCityList = new ArrayList<>(Arrays.asList("郑州市", "开封市", "洛阳市", "平顶山市", "安阳市", "鹤壁市", "新乡市", "焦作市", "濮阳市", "许昌市", "漯河市", "三门峡市", "南阳市", "商丘市", "信阳市", "周口市", "驻马店市"));
        huBeiCityList = new ArrayList<>(Arrays.asList("武汉市", "黄石市", "十堰市", "宜昌市", "襄阳市", "鄂州市", "荆门市", "孝感市", "荆州市", "黄冈市", "咸宁市", "随州市", "恩施土家族苗族自治州"));
        huNanCityList = new ArrayList<>(Arrays.asList("长沙市", "株洲市", "湘潭市", "衡阳市", "邵阳市", "岳阳市", "常德市", "张家界市", "益阳市", "郴州市", "永州市", "怀化市", "娄底市", "湘西土家族苗族自治州"));
        guangDongCityList = new ArrayList<>(Arrays.asList("广州市", "韶关市", "深圳市", "珠海市", "汕头市", "佛山市", "江门市", "湛江市", "茂名市", "肇庆市", "惠州市", "梅州市", "汕尾市", "河源市", "阳江市", "清远市", "东莞市", "中山市", "潮州市", "揭阳市", "云浮市"));
        guangXiCityList = new ArrayList<>(Arrays.asList("南宁市", "柳州市", "桂林市", "梧州市", "北海市", "防城港市", "钦州市", "贵港市", "玉林市", "百色市", "贺州市", "河池市", "来宾市", "崇左市"));
        haiNanCityList = new ArrayList<>(Arrays.asList("海口市", "三亚市", "三沙市", "儋州市", "五指山市", "琼海市", "文昌市", "万宁市", "东方市", "定安县", "屯昌县", "澄迈县", "临高县", "白沙黎族自治县", "昌江黎族自治县", "乐东黎族自治县", "陵水黎族自治县", "保亭黎族苗族自治县", "琼中黎族苗族自治县"));
        siChuanCityList = new ArrayList<>(Arrays.asList("成都市", "自贡市", "攀枝花市", "泸州市", "德阳市", "绵阳市", "广元市", "遂宁市", "内江市", "乐山市", "南充市", "眉山市", "宜宾市", "广安市", "达州市", "雅安市", "巴中市", "资阳市", "阿坝藏族羌族自治州", "甘孜藏族自治州", "凉山彝族自治州"));
        guiZhouCityList = new ArrayList<>(Arrays.asList("贵阳市", "六盘水市", "遵义市", "安顺市", "毕节市", "铜仁市", "黔西南布依族苗族自治州", "黔东南苗族侗族自治州", "黔南布依族苗族自治州"));
        yunNanCityList = new ArrayList<>(Arrays.asList("昆明市", "曲靖市", "玉溪市", "保山市", "昭通市", "丽江市", "普洱市", "临沧市", "楚雄彝族自治州", "红河哈尼族彝族自治州", "文山壮族苗族自治州", "西双版纳傣族自治州", "大理白族自治州", "德宏傣族景颇族自治州", "怒江傈僳族自治州", "迪庆藏族自治州"));
        xiZangCityList = new ArrayList<>(Arrays.asList("拉萨市", "日喀则市", "昌都市", "林芝市", "山南地区", "那曲地区", "阿里地区"));
        shaanXiCityList = new ArrayList<>(Arrays.asList("西安市", "铜川市", "宝鸡市", "咸阳市", "渭南市", "延安市", "汉中市", "榆林市", "安康市", "商洛市"));
        ganSuCityList = new ArrayList<>(Arrays.asList("兰州市", "嘉峪关市", "金昌市", "白银市", "天水市", "武威市", "张掖市", "平凉市", "酒泉市", "庆阳市", "定西市", "陇南市", "临夏回族自治州", "甘南藏族自治州"));
        qingHaiCityList = new ArrayList<>(Arrays.asList("西宁市", "海东市", "海北藏族自治州", "黄南藏族自治州", "海南藏族自治州", "果洛藏族自治州", "玉树藏族自治州", "海西蒙古族藏族自治州"));
        ningXiaCityList = new ArrayList<>(Arrays.asList("银川市", "石嘴山市", "吴忠市", "固原市", "中卫市"));
        xinJiangCityList = new ArrayList<>(Arrays.asList("乌鲁木齐市", "克拉玛依市", "吐鲁番市", "哈密地区", "昌吉回族自治州", "博尔塔拉蒙古自治州", "巴音郭楞蒙古自治州", "阿克苏地区", "克孜勒苏柯尔克孜自治州", "喀什地区", "和田地区", "伊犁哈萨克自治州", "塔城地区", "阿勒泰地区"));

        provinceCityMap.put("北京",beiJingCityList);
        provinceCityMap.put("天津",tianJingCityList);
        provinceCityMap.put("上海",shangHaiCityList);
        provinceCityMap.put("重庆",chongQingCityList);
        provinceCityMap.put("河北",heBeiCityList);
        provinceCityMap.put("山西",shanXiCityList);
        provinceCityMap.put("内蒙古",neiMengGuCityList);
        provinceCityMap.put("辽宁",liaoNingCityList);
        provinceCityMap.put("吉林",jiLinCityList);
        provinceCityMap.put("黑龙江",heiLongJiangCityList);
        provinceCityMap.put("江苏",jiangSuCityList);
        provinceCityMap.put("浙江",zheJiangCityList);
        provinceCityMap.put("安徽",anHuiCityList);
        provinceCityMap.put("福建",fuJianCityList);
        provinceCityMap.put("江西",jiangXiCityList);
        provinceCityMap.put("山东",shanDongCityList);
        provinceCityMap.put("河南",heNanCityList);
        provinceCityMap.put("湖北",huBeiCityList);
        provinceCityMap.put("湖南",huNanCityList);
        provinceCityMap.put("广东",guangDongCityList);
        provinceCityMap.put("广西",guangXiCityList);
        provinceCityMap.put("海南",haiNanCityList);
        provinceCityMap.put("四川",siChuanCityList);
        provinceCityMap.put("贵州",guiZhouCityList);
        provinceCityMap.put("云南",yunNanCityList);
        provinceCityMap.put("西藏",xiZangCityList);
        provinceCityMap.put("陕西",shaanXiCityList);
        provinceCityMap.put("甘肃",ganSuCityList);
        provinceCityMap.put("青海",qingHaiCityList);
        provinceCityMap.put("宁夏",ningXiaCityList);
        provinceCityMap.put("新疆",xinJiangCityList);
        provinceCityMap.put("台湾",taiWanCityList);
        provinceCityMap.put("香港",xiangGangCityList);
        provinceCityMap.put("澳门",aoMenCityList);
    }

}
