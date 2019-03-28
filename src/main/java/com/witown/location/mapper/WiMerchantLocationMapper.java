package com.witown.location.mapper;

import com.witown.location.entity.WiMerchantLocation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 店铺精确定位位置 Mapper 接口
 * </p>
 *
 * @author hello
 * @since 2019-03-11
 */
public interface WiMerchantLocationMapper extends BaseMapper<WiMerchantLocation> {

    List<WiMerchantLocation> selectByPage(int current);

    int total();

    List<String> getId(int current);

}
