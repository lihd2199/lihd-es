package com.lihd.es.controller;

import com.lihd.es.api.range.RangeQueryRequest;
import com.lihd.es.api.range.RangeQueryResponse;
import com.lihd.es.bo.ProductBO;
import com.lihd.es.api.ResultInfo;
import com.lihd.es.api.simple.SimpleQueryRequest;
import com.lihd.es.api.simple.SimpleQueryResponse;
import com.lihd.es.service.QueryService;
import com.lihd.es.service.range.builder.RangeRequestBuilder;
import com.lihd.es.service.simple.builder.SimpleSelectRequestBuilder;
import com.lihd.es.service.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-05 22:07
 **/
@RestController
@RequestMapping(method = {RequestMethod.POST})
@Api(value = "query")
public class SimpleSelectController {

    @Resource
    private SimpleSelectRequestBuilder simpleSelectRequestBuilder;
    @Resource
    private ResponseBuilder responseBuilder;
    @Resource
    private RangeRequestBuilder rangeRequestBuilder;
    @Resource
    private QueryService queryService;


    @ApiOperation(value = "简单非聚合查询")
    @RequestMapping("/query")
    public SimpleQueryResponse query(SimpleQueryRequest queryRequest) {

        SimpleQueryResponse simpleQueryResponse = new SimpleQueryResponse();
        ResultInfo resultInfo = ResultInfo.init();

        try {
            final SearchSourceBuilder searchSourceBuilder = simpleSelectRequestBuilder.getSearchSourceBuilder(queryRequest);
            final SearchResponse response = queryService.query(searchSourceBuilder);
            final List<ProductBO> productList = responseBuilder.getProductList(response);
            simpleQueryResponse.setProductList(productList);

        } catch (Exception e) {
            resultInfo.setSuccess(false);
            resultInfo.setMessage(e.getMessage());

        }

        simpleQueryResponse.setResultInfo(resultInfo);
        return simpleQueryResponse;

    }


    @ApiOperation(value = "range查询")
    @RequestMapping("/range")
    public RangeQueryResponse rangeQuery(RangeQueryRequest queryRequest) {

        RangeQueryResponse rangeQueryResponse = new RangeQueryResponse();
        ResultInfo resultInfo = ResultInfo.init();

        try {
            final SearchSourceBuilder searchSourceBuilder = rangeRequestBuilder.getSearchSourceBuilder(queryRequest);
            final SearchResponse response = queryService.query(searchSourceBuilder);
            final List<ProductBO> productList = responseBuilder.getProductList(response);
            rangeQueryResponse.setProductList(productList);

        } catch (Exception e) {
            resultInfo.setSuccess(false);
            resultInfo.setMessage(e.getMessage());

        }

        rangeQueryResponse.setResultInfo(resultInfo);
        return rangeQueryResponse;

    }


}
