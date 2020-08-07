package com.lihd.es.api.simple;

import com.lihd.es.api.PageInfo;
import com.lihd.es.bo.ProductBO;
import com.lihd.es.api.ResultInfo;
import lombok.Data;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-07 18:52
 **/
@Data
public class SimpleQueryResponse {

    private List<ProductBO> productList;

    private PageInfo pageInfo;

    private ResultInfo resultInfo;

}
