package com.lihd.es.service.impl;

import com.lihd.es.service.QueryService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: li_hd
 * @date: 2020-08-07 11:11
 **/
@Service
public class QueryServiceImpl implements QueryService {

    @Resource
    private RestHighLevelClient client;
    @Value("${es.indices}")
    private String indices;

    @Override
    public SearchResponse query(SearchSourceBuilder builder) throws IOException {
        SearchRequest request = new SearchRequest();
        //索引
        request.indices(indices);
        //组合条件
        request.source(builder);
        return client.search(request);
    }

}
