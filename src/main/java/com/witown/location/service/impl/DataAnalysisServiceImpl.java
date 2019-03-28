package com.witown.location.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.witown.location.entity.*;
import com.witown.location.mapper.WiLocationMapper;
import com.witown.location.mapper.WiMerchantLocationMapper;
import com.witown.location.mapper.WiMerchantMapper;
import com.witown.location.mapper.WiMerchantPositionMapper;
import com.witown.location.service.DataAnalysisService;
import com.witown.location.utils.NetUtil;
import com.witown.location.utils.SimilarityRatioUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 店铺信息提取
 *
 * @author ding
 *
 * Created by ding on 2019/3/8 19:50
 */
@Service
public class DataAnalysisServiceImpl implements DataAnalysisService{

    @Autowired
    private WiMerchantLocationMapper locationMapper;

    @Autowired
    private WiMerchantPositionMapper positionMapper;

    @Autowired
    private WiMerchantMapper merchantMapper;

    @Autowired
    private WiLocationMapper mapper;

    @Override
    public String getGaodeInfo(String lat, String lng, String keywords) {
        return null;
    }

    @Override
    public String coordinateConvert(String location) {
        return null;
    }


    private String getGaodeType(String type) {
        if (type.startsWith("110")) {
            //美食
            return "餐饮服务";
        } else if (type.startsWith("120")) {
            //购物
            return null;
        }else if(type.startsWith("130")){
            //休闲娱乐
            return null;
        }else if(type.startsWith("140")){
            //丽人
            return null;
        } else if (type.startsWith("150")) {
            return null;
            //结婚
        } else if (type.startsWith("160")) {
            //运动健身
//            return "体育休闲服务";
        } else if (type.startsWith("170")) {
            //酒店
            return "住宿服务";
        } else if (type.startsWith("180")) {
            //生活服务
//            return "生活服务";
        } else if (type.startsWith("190")) {
            //交通
//            return "交通设施服务";
        } else if (type.startsWith("200")) {
            //会展中心
//            return "科教文化服务";
        } else if (type.startsWith("210")) {
            //社区
        }

        return null;
    }

    private String beautify(String shortTitle) {

        shortTitle = shortTitle.replace("。", "");
        shortTitle = shortTitle.replace(".", "");
        shortTitle = shortTitle.replace("*", "");
        shortTitle = shortTitle.replace("&", "");

        if (shortTitle.contains("市") && !shortTitle.contains("超市")
                && !shortTitle.contains("市场") && !shortTitle.contains("都市")
                && !shortTitle.contains("城市")
                ) {
            shortTitle = shortTitle.split("市")[1];
        }
        if (shortTitle.contains("县") && !shortTitle.contains("沙县")) {
            shortTitle = shortTitle.split("县")[1];
        }
        if (shortTitle.contains("镇")) {
            shortTitle = shortTitle.split("镇")[1];
        }
        if (shortTitle.contains("区")) {
            shortTitle = shortTitle.split("区")[1];
        }
        if (shortTitle.contains("村")) {
            shortTitle = shortTitle.split("市")[1];
        }
        if (shortTitle.contains("(虚实) ")) {
            shortTitle = shortTitle.replace("(虚实) ","");
        }
        if (shortTitle.endsWith("大堂")) {
            shortTitle = shortTitle.split("大堂")[0];
        }
        if (shortTitle.endsWith("前台")) {
            shortTitle = shortTitle.split("前台")[0];
        }
        if (shortTitle.endsWith("大厅")) {
            shortTitle = shortTitle.split("大厅")[0];
        }
        if (shortTitle.endsWith("总台")) {
            shortTitle = shortTitle.split("总台")[0];
        }
        if (shortTitle.startsWith("（")) {
            shortTitle = shortTitle.split("）")[1];
        }
        if (shortTitle.endsWith("）")) {
            shortTitle = shortTitle.split("（")[0];
        }
        if (shortTitle.startsWith("(")) {
            shortTitle = shortTitle.split(")")[1];
        }
        if (shortTitle.endsWith(")")) {
            shortTitle = shortTitle.split("(")[0];
        }
        if(shortTitle.startsWith("（虚实）")){
            shortTitle = shortTitle.split("（虚实）")[1];
        }

        shortTitle = shortTitle.split("1楼")[0].split("一楼")[0].split("1F")[0]
                .split("2楼")[0].split("二楼")[0]
                .split("3楼")[0].split("三楼")[0]
                .split("4楼")[0].split("四楼")[0]
                .split("5楼")[0].split("五楼")[0].split("-")[0];
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(shortTitle);
        shortTitle = matcher.replaceAll("").trim();

        Pattern pattern2 = Pattern.compile("^[N|C|c|n]\\d+");
        Matcher matcher2 = pattern2.matcher(shortTitle);
        shortTitle = matcher2.replaceAll("").trim();

        String[] names = {"学校","酒店","理发店","饭店","快餐店","美发店","旅店","公寓","医院","银行","信用社","超市","酒吧","小吃",
        "网吧","网咖","会所","餐厅","幼儿园","药房","面馆","书店","商场","咖啡厅","连锁店","旗舰店","茶楼","饭庄","宾馆","麻辣烫","碳烤吧","鑫海洗浴",
                "诊所","家常菜","KTV","客栈","宿舍","牛肉面","饺子馆","寝室","大世界"
        };
        for (String name : names) {
            if (shortTitle.contains(name)) {
                shortTitle = shortTitle.substring(0,shortTitle.indexOf(name) + name.length());
            }
        }
        //剔除分店结尾的店名，如可莎蜜儿西湖店
        if (shortTitle.contains("店") && !shortTitle.contains("旗舰店") &&
                !shortTitle.contains("酒店") && !shortTitle.contains("理发店") &&
                !shortTitle.contains("旅店") && !shortTitle.contains("饭店") &&
                !shortTitle.contains("杂货店") && !shortTitle.contains("面店") &&
                !shortTitle.contains("洗衣店") && !shortTitle.contains("专卖店") &&
                !shortTitle.contains("药店") && !shortTitle.contains("连锁店")&&
                !shortTitle.contains("足浴店") && !shortTitle.contains("横店") &&
                !shortTitle.contains("咖啡店") && !shortTitle.contains("自营店")
        ) {
            //如：横城店
            shortTitle = shortTitle.substring(0,shortTitle.length() - 3);
        }
        //去掉售楼部
        String[] names2 = {"售楼部"};
        for (String name : names2) {
            if (shortTitle.contains(name)) {
                shortTitle = shortTitle.substring(0,shortTitle.length() - name.length());
            }
        }

        if (shortTitle.contains("吉纤")) {
            shortTitle = StringUtils.replace(shortTitle, "寝室", "宿舍");
        }

        if (shortTitle.contains("化纤") && shortTitle.contains("宿舍")) {
            shortTitle = "化纤住宅小区";
        }


        return shortTitle;
    }

    /**
     * 比较原始名字和高德获取到的店铺名字的相似度
     *
     * @param beautify 美化后的原始店铺名字
     * @param name 高德获取
     * @return
     */
    private void beautify2(String beautify, String name) {
        String beautify2 = null;
        if (name.contains("(")) {
            beautify2 = name.split("\\(")[0];
        } else {
            beautify2 = name;
        }

        float similarityRatio = SimilarityRatioUtils.getSimilarityRatio(beautify, beautify2);
        System.out.println("美化相识度：" + similarityRatio + ",美化|高德【" + beautify + "|" + name + "】");
    }

    /**
     * go
     */
    @Override
    public void go() {
        int total = locationMapper.total();
        int pages = total/20 + 1;
        for (int i = 0; i < pages; i++) {
            List<String> ids = locationMapper.getId(i * 20);

            for (String id : ids) {

                try {
                    //高德经纬度
                    String lat = null;
                    String lng = null;

                    //周边查询
                    String locations;

                    WiMerchantLocation merchantLocation = locationMapper.selectById(id);

                    QueryWrapper<WiMerchant> queryWrapper = new QueryWrapper<WiMerchant>().eq("merchantId", id);
                    WiMerchant merchant = merchantMapper.selectOne(queryWrapper);
                    if(merchant.getShortitle().contains("测试")){
                        System.out.println("发现测试店铺:" + id + "," + merchant.getShortitle());
                        continue;
                    }

                    //原始名字
                    String shorTitle = merchant.getShortitle();
                    //原始店铺位置
                    String treebearLocation = merchant.getAreaValue() + merchant.getLocation();
                    //美化后的原始名字
                    String beautify = beautify(shorTitle);

                    //区分是定位获取的还是原始获取
                    String source = null;
                    //若定位为空，变从原始值获取
                    if (merchantLocation == null) {
                        lat = merchant.getLatitude().toString();
                        lng = merchant.getLongitude().toString();
                        source = "原始位置";
                        locations = lng + "," + lat;
                    }else{
                        //百度坐标转换为高德坐标
                        source = "百度定位";
                        lng = merchantLocation.getLng();
                        lat = merchantLocation.getLat();
                        locations = NetUtil.getGaodeCoordinate(lng + "," + lat);
                    }

                    //认为订正数据
                    WiLocation location = mapper.get(id);
                    if (location != null) {
                        beautify = location.getName();
                        locations = location.getLng() + "," + location.getLat();
                    }

                    GaodeResponse gaode = NetUtil.gaode(locations, beautify);
                    if (gaode.getPois().size() == 0) {
                        System.out.println(merchant.getMerchantId() + ":根据经纬度未查询到周边结果");
                        continue;
                    }

                    GaodePois gaodePois = gaode.getPois().get(0);
                    System.out.println("高德周边结果：" + JSON.toJSONString(gaodePois, true));
                    String name = gaodePois.getName();
                    String type = gaodePois.getType();
                    beautify2(beautify, name);

                    if (!merchant.getAreaValue().contains(gaodePois.getCityname())) {
                        System.out.println("设备未在原始店铺：" + merchant.getMerchantId() + ",原地址：" + merchant.getAreaValue() + ",新地址" + gaodePois.getCityname());
                    }

                    WiMerchantPosition position = new WiMerchantPosition();
                    position.setMerchantId(id);
                    position.setShortTitle(shorTitle);
                    position.setTreebearAddress(treebearLocation);
                    position.setLat(lat);
                    position.setLng(lng);
                    position.setBizType(merchant.getBizType());
                    position.setName(name);
                    if (type != null && !"[]".equals(type)) {
                        String[] split = type.split(";");
                        position.setOne(split[0]);
                        position.setTwo(split[1]);
                        position.setThree(split[2]);
                    }
                    position.setTag("[]".equals(gaodePois.getTag()) ? null:gaodePois.getTag());
                    position.setBunsiness("[]".equals(gaodePois.getBusiness_area()) ? null:gaodePois.getBusiness_area());
                    position.setAddress(gaodePois.getAddress());

                    position.setProvince(gaodePois.getPname());
                    position.setCity(gaodePois.getCityname());
                    position.setDistrict(gaodePois.getAdname());
                    position.setSource(source);

                    positionMapper.insert(position);
                    System.out.println("插入操作.......");
                } catch (Exception e) {
                    System.out.println("异常:" + id +",cause:" + e);
                }
            }

        }

    }

    public static void main(String[] args) {
        String shortTitle = "吉纤二寝室";
        shortTitle = StringUtils.replace(shortTitle, "寝室", "宿舍");
        System.out.println(shortTitle);
    }
}
