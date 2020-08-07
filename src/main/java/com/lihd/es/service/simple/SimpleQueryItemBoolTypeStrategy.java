package com.lihd.es.service.simple;

import com.lihd.es.enums.QueryRequestItemBoolTypeEnum;
import org.elasticsearch.index.query.BoolQueryBuilder;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: li_hd
 * @date: 2020-08-07 19:15
 **/
public class SimpleQueryItemBoolTypeStrategy {

    private SimpleQueryItemBoolTypeStrategy() {
    }

    private final static SimpleQueryItemBoolTypeService MUST_QUERY = BoolQueryBuilder::must;

    private final static SimpleQueryItemBoolTypeService SHOULD_QUERY = BoolQueryBuilder::should;

    private final static SimpleQueryItemBoolTypeService MUST_NOT_QUERY = BoolQueryBuilder::mustNot;

    public static ConcurrentHashMap<QueryRequestItemBoolTypeEnum, SimpleQueryItemBoolTypeService> STRATEGY = new ConcurrentHashMap<>();

    static {
        STRATEGY.put(QueryRequestItemBoolTypeEnum.MUST, MUST_QUERY);
        STRATEGY.put(QueryRequestItemBoolTypeEnum.SHOULD, SHOULD_QUERY);
        STRATEGY.put(QueryRequestItemBoolTypeEnum.MUST_NOT, MUST_NOT_QUERY);

    }

}
