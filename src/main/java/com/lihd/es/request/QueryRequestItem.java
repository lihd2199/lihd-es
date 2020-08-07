package com.lihd.es.request;

import com.lihd.es.enums.QueryRequestItemBoolTypeEnum;
import com.lihd.es.enums.QueryRequestItemTypeEnum;
import lombok.Data;

/**
 * @author: li_hd
 * @date: 2020-08-06 13:54
 **/
@Data
public class QueryRequestItem {

    private String field;

    private String value;

    private QueryRequestItemTypeEnum queryRequestItemType;

    private QueryRequestItemBoolTypeEnum queryRequestItemBoolTypeEnum;

}
