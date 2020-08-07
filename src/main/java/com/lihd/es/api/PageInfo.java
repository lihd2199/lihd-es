package com.lihd.es.api;

import lombok.Data;

/**
 * @author: li_hd
 * @date: 2020-08-07 20:05
 **/
@Data
public class PageInfo {

    private Integer from;

    private Integer size;

    private Integer totalCount;

}
