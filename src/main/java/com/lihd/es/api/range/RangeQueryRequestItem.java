package com.lihd.es.api.range;

import com.lihd.es.enums.RangeItemEnum;
import lombok.Data;

/**
 * @author: li_hd
 * @date: 2020-08-07 20:01
 **/
@Data
public class RangeQueryRequestItem {

    private String field;

    private Integer value;

    private RangeItemEnum rangeItemEnum;

}
