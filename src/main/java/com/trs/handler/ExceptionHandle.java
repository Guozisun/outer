package com.trs.handler;

import com.trs.exception.OuterException;
import com.trs.util.ErrorCodeKit;
import com.trs.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Title:
 * Description: 用来处理controller层的异常，统一返回值
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 20:09
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        Result result = Result.fail();

        if (e instanceof OuterException) {
            Map<String, Object> resultMap = ErrorCodeKit.getErrorMap((OuterException) e);
            result.setDETAIL((String) resultMap.get("ErrorDesc"));
            result.setData(resultMap);
            return result;
        } else {
            logger.error("系统内部错误，cause by:" + e.getMessage(), e);
            result.setData(ErrorCodeKit.getSystemErrorMap());
            result.setDETAIL((String) ErrorCodeKit.getSystemErrorMap().get("ErrorDesc"));
            return result;
        }
    }

}
