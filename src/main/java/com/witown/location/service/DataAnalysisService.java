package com.witown.location.service;

/**
 * 店铺商业信息提取
 *
 * @author ding
 *
 * Created by ding on 2019/3/8 19:49
 */
public interface DataAnalysisService {

    void go();

    String getGaodeInfo(String lat, String lng, String keywords);

    /**
     * 百度坐标转高德坐标
     *
     * @param location 百度坐标
     * @return 高德坐标
     */
    String coordinateConvert(String location);
}
