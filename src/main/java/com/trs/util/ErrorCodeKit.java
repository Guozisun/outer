package com.trs.util;

import com.trs.constants.SystemErrorCode;
import com.trs.exception.OuterException;

import java.util.Map;

/**
 * Title:
 * Description:异常错误码处理类
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 20:20
 */
public class ErrorCodeKit {
    private ErrorCodeKit() {

    }

    /**
     * 捕获的异常返回错误码map
     *
     * @param e 异常对象
     * @return map
     */
    public static Map<String, Object> getErrorMap(OuterException e) {
        return e.getErrorCode().toMap(e.getDesc());
    }

    /**
     * 所有的非自定义异常返回此错误码
     *
     * @return map
     */
    public static Map<String, Object> getSystemErrorMap() {
        return SystemErrorCode.SYSTEM_ERROR.toMap("");
    }
}
