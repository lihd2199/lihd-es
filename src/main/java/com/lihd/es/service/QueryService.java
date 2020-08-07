package com.lihd.es.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author: li_hd
 * @date: 2020-08-07 11:10
 **/
public interface QueryService {
    SearchResponse query(SearchSourceBuilder builder) throws IOException;
}
