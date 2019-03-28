package com.witown.location.entity;

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
 * @since 2019-03-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WiLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lat;

    private String lng;

    private String name;


}
