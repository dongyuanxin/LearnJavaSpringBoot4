package com.imooc.luckmoney.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * HTTP 返回的最外层对象
 */
@Getter
@Setter
@NoArgsConstructor
public class HttpApiResult<T> {
    private String code;

    private String message;

    private T data;
}
