package com.imooc.luckmoney.exception;

import com.imooc.luckmoney.domain.ResultStatus;

/**
 * Spring 只有对 RuntimeException 才会进行事务回滚。所以这里要继承 RuntimeException
 */
public class HttpApiBaseException extends RuntimeException {
    private String code;

    public HttpApiBaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public HttpApiBaseException(ResultStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
