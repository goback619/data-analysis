package com.witown.location.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 店铺精确定位位置
 * </p>
 *
 * @author hello
 * @since 2019-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WiMerchantPosition implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID
     */
    @TableId("merchantId")
    private String merchantId;

    /**
     * 高德店铺名称
     */
    private String name;

    /**
     * 树熊店铺名称
     */
    @TableField("shortTitle")
    private String shortTitle;

    /**
     * s树熊店铺名称
     */
    @TableField("bizType")
    private String bizType;

    /**
     * 高德一级poi类型，如：餐饮服务;快餐厅;呷哺呷哺
     */
    private String one;
    /**
     * 高德二级店铺poi类型，如：餐饮服务;快餐厅;呷哺呷哺
     */
    private String two;
    /**
     * 高德三级店铺poi类型，如：餐饮服务;快餐厅;呷哺呷哺
     */
    private String three;

    /**
     * 定位信息来源：原始店铺/portal页面定位
     */
    @TableField("source")
    private String source;

    @TableField("address")
    private String address;

    /**
     * 高德标签
     */
    @TableField("tag")
    private String tag;

    /**
     * 树熊地址
     */
    @TableField("treebearAddress")
    private String treebearAddress;

    @TableField("bunsiness")
    private String bunsiness;

    /**
     * 省名
     */
    private String province;

    /**
     * 城市名
     */
    private String city;

    /**
     * 区县名
     */
    private String district;

    /**
     * 乡镇名
     */
    private String town;

    /**
     * 街道名（行政区划中的街道层级）
     */
    private String street;

    /**
     * 街道门牌号
     */
    @TableField("streetNumber")
    private String streetNumber;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    @TableField("gmtCreated")
    private LocalDateTime gmtCreated;

    @TableField("gmtModified")
    private LocalDateTime gmtModified;


}
