package com.imooc.luckmoney.utils;

import com.imooc.luckmoney.domain.HttpApiResult;
import com.imooc.luckmoney.domain.ResultStatus;

public class ResultFormat {
    public static HttpApiResult success(Object data) {
        HttpApiResult result = new HttpApiResult();
        result.setCode(ResultStatus.SUCCESS.getCode());
        result.setMessage(ResultStatus.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static HttpApiResult success() {
        return success(null);
    }

    public static HttpApiResult error(String code, String message) {
        HttpApiResult result = new HttpApiResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static HttpApiResult error(ResultStatus status) {
        return error(status.getCode(), status.getMessage());
    }
}
