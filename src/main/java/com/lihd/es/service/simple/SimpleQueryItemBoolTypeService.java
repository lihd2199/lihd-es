package com.lihd.es.service.simple;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author: li_hd
 * @date: 2020-08-07 19:44
 **/
public interface SimpleQueryItemBoolTypeService {

    void boolQueryBuilderQuery(BoolQueryBuilder boolQueryBuilder, QueryBuilder queryBuilder);

}
