package com.lihd.es.request;

import lombok.Data;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-06 16:04
 **/
@Data
public class QueryRequest {

    private List<QueryRequestItem> queryRequestItemList;

    private Integer from;

    private Integer size;


}
