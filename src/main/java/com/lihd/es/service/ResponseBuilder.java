package com.lihd.es.service;

import com.lihd.es.bo.ProductBO;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: li_hd
 * @date: 2020-08-06 19:57
 **/
@Component
public class ResponseBuilder {

    public List<ProductBO> getProductList(SearchResponse response) {

        List<ProductBO> productList = new ArrayList<>();
        final SearchHit[] hits = response.getHits().getHits();

        for (SearchHit hit : hits) {
            final ProductBO product = new ProductBO();
            final Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            BeanMap beanMap = BeanMap.create(product);
            beanMap.putAll(sourceAsMap);
            productList.add(product);

        }

        return productList;
    }


}
