package com.lihd.es.bo;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author: li_hd
 * @date: 2020-08-06 16:10
 **/
@Data
public class ProductBO {

    private Integer productId;

    private String productName;

    private String productMainTitle;

    private String productSubTitle;

    private Integer recommend;
}
