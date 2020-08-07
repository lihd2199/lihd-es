package com.lihd.es.service.range;

import org.elasticsearch.index.query.RangeQueryBuilder;

/**
 * @author: li_hd
 * @date: 2020-08-07 20:23
 **/
public interface RangeItemService {

    void rangeItemService(RangeQueryBuilder boolQueryBuilder, Integer queryBuilder);

}
