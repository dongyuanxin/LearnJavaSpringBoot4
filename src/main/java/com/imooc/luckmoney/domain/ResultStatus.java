package com.imooc.luckmoney.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultStatus {
    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知异常"),
    PARAMS_ERROR("PARAMS_ERROR", "参数错误"),
    SUCCESS("SUCCESS", "成功"),
    USER_UNVALID("USER_UNVALID", "用户未参加工作");

    public final String code;

    public final String message;
}
