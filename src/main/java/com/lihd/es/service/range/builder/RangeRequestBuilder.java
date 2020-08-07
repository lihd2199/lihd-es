package com.lihd.es.service.range.builder;

import com.lihd.es.api.range.RangeQueryRequest;
import com.lihd.es.api.range.RangeQueryRequestItem;
import com.lihd.es.service.range.RangeItemStrategy;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-07 20:28
 **/
@Component
public class RangeRequestBuilder {


    public SearchSourceBuilder getSearchSourceBuilder(RangeQueryRequest queryRequest) {

        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        final List<RangeQueryRequestItem> rangeQueryRequestItemList = queryRequest.getRangeQueryRequestItemList();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        for (RangeQueryRequestItem rangeQueryRequestItem : rangeQueryRequestItemList) {
            boolQueryBuilder.must(getRangeQueryBuilder(rangeQueryRequestItem));

        }

        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.size(queryRequest.getPageInfo() == null ? 10 : queryRequest.getPageInfo().getSize());
        searchSourceBuilder.from(queryRequest.getPageInfo() == null ? 0 : queryRequest.getPageInfo().getFrom());


        return searchSourceBuilder;
    }

    private QueryBuilder getRangeQueryBuilder(RangeQueryRequestItem rangeQueryRequestItem) {

        final RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder(rangeQueryRequestItem.getField());

        RangeItemStrategy.STRATEGY.get(rangeQueryRequestItem.getRangeItemEnum()).rangeItemService(rangeQueryBuilder, rangeQueryRequestItem.getValue());

        return rangeQueryBuilder;

    }


}
