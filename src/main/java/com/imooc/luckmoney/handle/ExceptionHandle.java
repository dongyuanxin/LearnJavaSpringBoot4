package com.imooc.luckmoney.handle;

import com.imooc.luckmoney.domain.HttpApiResult;
import com.imooc.luckmoney.domain.ResultStatus;
import com.imooc.luckmoney.exception.HttpApiBaseException;
import com.imooc.luckmoney.utils.ResultFormat;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器增强：
 * - 全局异常处理：集中处理整个应用程序中所有控制器抛出的异常
 * - 全局数据绑定：统一处理请求参数绑定
 * - 全局数据预处理：对所有控制器的输入输出进行统一处理
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody // 方法返回值直接写入 HTTP 响应体（response body）中，而不是解析为视图名称
    public HttpApiResult handle(Exception e) {
        if (e instanceof HttpApiBaseException) {
            HttpApiBaseException baseException = (HttpApiBaseException) e;
            return ResultFormat.error(baseException.getCode(), e.getMessage());
        }

        return ResultFormat.error(ResultStatus.UNKNOWN_ERROR);
    }
}
