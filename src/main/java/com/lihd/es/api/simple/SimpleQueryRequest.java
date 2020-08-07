package com.lihd.es.api.simple;

import com.lihd.es.api.PageInfo;
import lombok.Data;

import java.util.List;


/**
 * @author: li_hd
 * @date: 2020-08-06 13:52
 **/
@Data
public class SimpleQueryRequest {

    private List<SimpleQueryRequestItem> simpleQueryRequestItemList;

    private PageInfo pageInfo;

}
