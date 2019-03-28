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
 * @since 2019-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WiMerchantLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 店铺ID
     */
    @TableId("merchantId")
    private String merchantId;

    /**
     * 结构化地址信息
     */
    private String formattedAddress;

    /**
     * 当前位置结合POI的语义化结果描述。
     */
    private String sematicDescription;

    /**
     * 坐标所在商圈信息，如 "人民大学,中关村,苏州街"。最多返回3个。
     */
    private String business;

    private String country;

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
    private String streetNumber;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 归属区域面名称。如：西湖风景区
     */
    private String poiRegionsName;

    /**
     * 归属区域面类型。如：旅游景点;风景区。
     */
    private String poiRegionsTag;
}
