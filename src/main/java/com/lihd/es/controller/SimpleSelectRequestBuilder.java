package com.lihd.es.controller;

import com.lihd.es.enums.QueryRequestItemBoolTypeEnum;
import com.lihd.es.enums.QueryRequestItemTypeEnum;
import com.lihd.es.request.QueryRequest;
import com.lihd.es.request.QueryRequestItem;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-06 17:18
 **/
@Component
public class SimpleSelectRequestBuilder {

    private static final String[] fields = new String[]{"productId", "productName", "productMainTitle", "productSubTitle", "recommend"};

    public SearchSourceBuilder getSearchSourceBuilder(QueryRequest queryRequest) {

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        final List<QueryRequestItem> queryRequestItemList = queryRequest.getQueryRequestItemList();

        for (QueryRequestItem queryRequestItem : queryRequestItemList) {
            dealBoolQueryBuilder(boolQueryBuilder, queryRequestItem);
        }

        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.size(queryRequest.getSize());
        searchSourceBuilder.from(queryRequest.getFrom());

        searchSourceBuilder.fetchSource(fields, null);

        return searchSourceBuilder;

    }

    private void dealBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder, QueryRequestItem queryRequestItem) {

        QueryBuilder queryBuilder = getQueryBuilder(queryRequestItem);
        if (queryRequestItem.getQueryRequestItemBoolTypeEnum().equals(QueryRequestItemBoolTypeEnum.MUST)) {
            boolQueryBuilder.must(queryBuilder);
        }
        if (queryRequestItem.getQueryRequestItemBoolTypeEnum().equals(QueryRequestItemBoolTypeEnum.SHOULD)) {
            boolQueryBuilder.should(queryBuilder);
        }
        if (queryRequestItem.getQueryRequestItemBoolTypeEnum().equals(QueryRequestItemBoolTypeEnum.MUST_NOT)) {
            boolQueryBuilder.mustNot(queryBuilder);
        }

    }

    private QueryBuilder getQueryBuilder(QueryRequestItem queryRequestItem) {
        QueryBuilder queryBuilder;
        if (queryRequestItem.getQueryRequestItemType().equals(QueryRequestItemTypeEnum.ITEM)) {
            queryBuilder = new TermQueryBuilder(queryRequestItem.getField(), queryRequestItem.getValue());
        } else {
            queryBuilder = new MatchQueryBuilder(queryRequestItem.getField(), queryRequestItem.getValue());
        }
        return queryBuilder;
    }


}
