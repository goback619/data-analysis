package com.witown.location.mapper;

import com.witown.location.entity.WiLocation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hello
 * @since 2019-03-18
 */
public interface WiLocationMapper extends BaseMapper<WiLocation> {

    WiLocation get(String id);

}
