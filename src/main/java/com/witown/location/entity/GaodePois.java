package com.witown.location.entity;

import lombok.Data;

/**
 *
 * @author ding
 *
 * Created by ding on 2019/3/11 11:47
 */
@Data
public class GaodePois {

    private String name;
    /**
     * 店铺类型
     */
    private String type;
    /**
     * 子类型
     */
    private String biz_type;
    /**
     * 店铺地址
     */
    private String address;
    /**
     * 省
     */
    private String pname;
    /**
     * 市
     */
    private String cityname;
    /**
     * 区域名称，区县级别的返回，例如朝阳区
     */
    private String adname;
    /**
     * 所在商圈
     */
    private String business_area;
    /**
     * 该POI的特色内容.如："奶茶,金桔柠檬绿茶"
     */
    private String tag;

}
