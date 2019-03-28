package com.witown.location.entity;

import lombok.Data;

/**
 * Created by ding on 2019/3/11 12:16
 */
@Data
public class BaiduResult {
    /**
     * 行政地址
     */
    private String formatted_address;

    /**
     * 商圈
     */
    private String business;
}
