package com.lihd.es.api.range;

import com.lihd.es.api.AbstractResponse;
import com.lihd.es.bo.ProductBO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author: li_hd
 * @date: 2020-08-07 18:52
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class RangeQueryResponse extends AbstractResponse {

    private List<ProductBO> productList;

}
