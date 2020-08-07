package com.lihd.es.service.range;

import com.lihd.es.enums.RangeItemEnum;
import org.elasticsearch.index.query.RangeQueryBuilder;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: li_hd
 * @date: 2020-08-07 20:17
 **/
public class RangeItemStrategy {

    private RangeItemStrategy() {
    }

    private final static RangeItemService GT = RangeQueryBuilder::gt;

    private final static RangeItemService GTE = RangeQueryBuilder::gte;

    private final static RangeItemService LT = RangeQueryBuilder::lt;

    private final static RangeItemService LTE = RangeQueryBuilder::lte;

    public static ConcurrentHashMap<RangeItemEnum, RangeItemService> STRATEGY = new ConcurrentHashMap<>();

    static {
        STRATEGY.put(RangeItemEnum.GT, GT);
        STRATEGY.put(RangeItemEnum.GTE, GTE);
        STRATEGY.put(RangeItemEnum.LT, LT);
        STRATEGY.put(RangeItemEnum.LTE, LTE);
    }

}
