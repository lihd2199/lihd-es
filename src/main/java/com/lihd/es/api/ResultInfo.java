package com.lihd.es.api;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: li_hd
 * @date: 2020-08-07 18:53
 **/
@Getter
@Setter
public class ResultInfo {

    public static ResultInfo init() {
        return new ResultInfo(true, "");
    }

    public static ResultInfo init(Boolean success, String message) {
        return new ResultInfo(success, message);
    }

    private ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private Boolean success;

    private String message;

}
