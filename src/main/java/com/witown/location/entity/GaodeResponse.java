package com.witown.location.entity;

import lombok.Data;

import java.util.List;

/**
 * 高德周边响应
 *
 * @author ding
 *
 * Created by ding on 2019/3/11 11:46
 */
@Data
public class GaodeResponse {

    private int status;

    private String info;

    private List<GaodePois> pois;
}
