package com.lihd.es.api.range;

import com.lihd.es.api.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-07 18:52
 **/
@Data
public class RangeQueryRequest {

    private List<RangeQueryRequestItem> rangeQueryRequestItemList;

    private PageInfo pageInfo;
}
