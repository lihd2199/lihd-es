package com.lihd.es.api.simple;

import com.lihd.es.enums.QueryRequestItemBoolTypeEnum;
import com.lihd.es.enums.QueryRequestItemTypeEnum;
import lombok.Data;

/**
 * @author: li_hd
 * @date: 2020-08-06 13:54
 **/
@Data
public class SimpleQueryRequestItem {

    private String field;

    private String value;

    private QueryRequestItemTypeEnum queryRequestItemType;

    private QueryRequestItemBoolTypeEnum queryRequestItemBoolTypeEnum;

}
