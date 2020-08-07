package com.lihd.es.request;

import lombok.Data;


/**
 * @author: li_hd
 * @date: 2020-08-06 13:52
 **/
@Data
public class SimpleQueryRequest {

    private QueryRequestItem queryRequestItem;

    private Integer size;

    private Integer from;

}
