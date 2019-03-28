package com.witown.location.entity;

import lombok.Data;

/**
 * Created by ding on 2019/3/11 17:59
 */
@Data
public class GaodeCoordinate {
    private int status;
    private String info;
    private String locations;
}
