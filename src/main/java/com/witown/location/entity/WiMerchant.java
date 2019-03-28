package com.witown.location.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.time.LocalTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hello
 * @since 2019-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WiMerchant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "autoId", type = IdType.AUTO)
    private Integer autoId;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 签到数量
     */
    @TableField("registrationCount")
    private Long registrationCount;

    /**
     * 注册时间
     */
    @TableField("gmtCreated")
    private LocalDateTime gmtCreated;

    /**
     * 修改时间
     */
    @TableField("gmtModified")
    private LocalDateTime gmtModified;

    /**
     * 是否删除：0不删除，1删除
     */
    @TableField("isDelete")
    private Boolean isDelete;

    /**
     * 商家地址
     */
    private String location;

    /**
     * 联系人
     */
    private String kp;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 商家名称
     */
    private String title;

    /**
     * 商家简介
     */
    private String directions;

    /**
     * 商圈编码
     */
    @TableField("areaCode")
    private String areaCode;

    /**
     * 商家类型 餐饮、娱乐
     */
    @TableField("bizType")
    private String bizType;

    /**
     * 首页bannerUrl
     */
    @TableField("loginBanner")
    private String loginBanner;

    /**
     * 商家头像
     */
    @TableField("userAvatar")
    private String userAvatar;

    /**
     * 商圈地址
     */
    @TableField("areaValue")
    private String areaValue;

    /**
     * 手机
     */
    private String mobile;

    @TableField("wiIp")
    private String wiIp;

    /**
     * 邮箱
     */
    private String email;

    @TableField("bannerHref")
    private String bannerHref;

    @TableField("wifiJoining")
    private Boolean wifiJoining;

    /**
     * 区域编码
     */
    @TableField("districtCode")
    private String districtCode;

    /**
     * 商家随即ID，目前VVZ用
     */
    @TableField("merchantId")
    private String merchantId;

    /**
     * 定制版本：0.非订制，1.订制版本1
     */
    @TableField("customVersion")
    private Integer customVersion;

    /**
     * 订制化URL
     */
    @TableField("customURL")
    private String customURL;

    @TableField("adAble")
    private Boolean adAble;

    @TableField("crossAdAble")
    private Boolean crossAdAble;

    private Boolean monitor;

    /**
     * 新浪微博UID
     */
    private String wbuid;

    /**
     * ΢
     */
    @TableField("weixinId")
    private String weixinId;

    private String shortitle;

    /**
     * ΢
     */
    private String weixinimage;

    /**
     * 有效期开始时间
     */
    @TableField("startDate")
    private LocalDateTime startDate;

    /**
     * 有效期截止时间
     */
    @TableField("dueDate")
    private LocalDateTime dueDate;

    /**
     * 商家审核状态：0.待审核，1.审核失败，9.审核成功
     */
    private Boolean verify;

    /**
     * 关联的连锁商家Id
     */
    @TableField("merchainId")
    private String merchainId;

    /**
     * 审核意见
     */
    private String verifymsg;

    /**
     * 腾讯微博链接地址
     */
    @TableField("tengxunwbUrl")
    private String tengxunwbUrl;

    /**
     * 官网链接地址
     */
    @TableField("guanwangUrl")
    private String guanwangUrl;

    /**
     * 淘宝链接地址
     */
    @TableField("taobaoUrl")
    private String taobaoUrl;

    /**
     * 先显示周边广告的秒数，<=0表示不显示
     */
    @TableField("adShowTimeInterval")
    private Integer adShowTimeInterval;

    /**
     * 显示店内活动，相册连接 Y 连接  N不连接
     */
    @TableField("showAction")
    private String showAction;

    /**
     * 自定义网址名称
     */
    @TableField("CustomName")
    private String CustomName;

    /**
     * 店铺活动标题
     */
    @TableField("activeTitle")
    private String activeTitle;

    /**
     * 关注我们标题
     */
    @TableField("followTitle")
    private String followTitle;

    /**
     * 店铺活动颜色
     */
    @TableField("activeColor")
    private String activeColor;

    /**
     * 关注我们颜色
     */
    @TableField("followColor")
    private String followColor;

    /**
     * 样式：blue蓝色,red红色,purple紫色,default默认
     */
    private String style;

    /**
     * 代理商ID
     */
    @TableField("agentId")
    private String agentId;

    /**
     * @desc 是否有微站点 y 有 | n 没有
     */
    @TableField("isWxSite")
    private String isWxSite;

    /**
     * 商家第一次绑定设备时间
     */
    private LocalDateTime firstroute;

    /**
     * 支付宝提供的商铺ID
     */
    @TableField("alipayShopId")
    private String alipayShopId;

    /**
     * 设备版本（0.默认版、1.媒体版、3. GPRS版）
     */
    private Boolean edition;

    /**
     * 网络模式 0 标准模式 1 空闲模式 2忙碌模式 3 自定义模式
     */
    @TableField("networkMode")
    private Boolean networkMode;

    @TableField("publicUrl")
    private String publicUrl;

    /**
     * 大众点评链接地址
     */
    @TableField("dazhongdpUrl")
    private String dazhongdpUrl;

    /**
     * 美团团购链接地址
     */
    @TableField("meituanTgUrl")
    private String meituanTgUrl;

    /**
     * 糯米团购链接地址
     */
    @TableField("nuomiTgUrl")
    private String nuomiTgUrl;

    @TableField("businessStartTime")
    private LocalTime businessStartTime;

    @TableField("businessEndTime")
    private LocalTime businessEndTime;

    /**
     * 店铺的网络模式
     */
    @TableField("netStruct")
    private Boolean netStruct;

    /**
     * 修改店铺属性或者删除店铺的操作员
     */
    @TableField("modifyAccountId")
    private Integer modifyAccountId;

    /**
     * 是否为有卖店铺 1：是 0：否
     */
    @TableField("isO2oShop")
    private String isO2oShop;

    /**
     * 是否开启网监 1：开启，0：关闭 默认关闭
     */
    @TableField("enableNetMonitor")
    private Boolean enableNetMonitor;

    /**
     * 是否开启DPI 1：开启，0：关闭 默认关闭
     */
    @TableField("enableDpi")
    private Boolean enableDpi;

    /**
     * 热点主ID
     */
    @TableField("wifiOwnerId")
    private Long wifiOwnerId;

    /**
     * 是否上报网监 0，否 1，是
     */
    @TableField("isReport")
    private String isReport;

    /**
     * 派出所编码
     */
    @TableField("policeCode")
    private String policeCode;

    /**
     * 是否KA：1：是；0：false
     */
    @TableField("isKa")
    private Boolean isKa;

    /**
     * 是否所有热点树熊可控：1：是；0：否
     */
    @TableField("isControl")
    private Boolean isControl;

    /**
     * 店铺税号
     */
    @TableField("taxNum")
    private String taxNum;


}
