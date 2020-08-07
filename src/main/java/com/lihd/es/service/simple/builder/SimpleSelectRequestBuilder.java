package com.lihd.es.service.simple.builder;

import com.lihd.es.api.PageInfo;
import com.lihd.es.api.simple.SimpleQueryRequest;
import com.lihd.es.api.simple.SimpleQueryRequestItem;
import com.lihd.es.consts.QueryConst;
import com.lihd.es.enums.QueryRequestItemBoolTypeEnum;
import com.lihd.es.enums.QueryRequestItemTypeEnum;
import com.lihd.es.service.simple.SimpleQueryItemBoolTypeStrategy;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-06 17:18
 **/
@Component
public class SimpleSelectRequestBuilder {


    public SearchSourceBuilder getSearchSourceBuilder(SimpleQueryRequest queryRequest) {

        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        final PageInfo pageInfo = queryRequest.getPageInfo();

        searchSourceBuilder.size(pageInfo == null ? 10 : pageInfo.getSize());
        searchSourceBuilder.from(pageInfo == null ? 0 : pageInfo.getFrom());
        searchSourceBuilder.fetchSource(QueryConst.FIELDS, null);

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        final List<SimpleQueryRequestItem> simpleQueryRequestItemList = queryRequest.getSimpleQueryRequestItemList();

        for (SimpleQueryRequestItem simpleQueryRequestItem : simpleQueryRequestItemList) {
            dealBoolQueryBuilder(boolQueryBuilder, simpleQueryRequestItem);

        }

        searchSourceBuilder.query(boolQueryBuilder);

        return searchSourceBuilder;

    }

    private void dealBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder, SimpleQueryRequestItem simpleQueryRequestItem) {

        QueryBuilder queryBuilder;
        if (simpleQueryRequestItem.getQueryRequestItemType().equals(QueryRequestItemTypeEnum.ITEM)) {
            queryBuilder = new TermQueryBuilder(simpleQueryRequestItem.getField(), simpleQueryRequestItem.getValue());
        } else {
            queryBuilder = new MatchQueryBuilder(simpleQueryRequestItem.getField(), simpleQueryRequestItem.getValue());
        }

        SimpleQueryItemBoolTypeStrategy.STRATEGY.get(simpleQueryRequestItem.getQueryRequestItemBoolTypeEnum()).boolQueryBuilderQuery(boolQueryBuilder, queryBuilder);

    }


}
