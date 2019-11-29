package com.trs.exception;

import com.trs.constants.SystemErrorCode;
import com.trs.util.DateKit;

import java.util.Date;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:52
 */
public class SystemErrorException extends OuterException {
    /**
     * 系统级异常构造
     *
     * @param errorCode 系统级异常错误码
     * @param apiName   接口信息
     * @param argument  替换错误码中的msg
     */
    public SystemErrorException(SystemErrorCode errorCode, String apiName, String argument) {
        super(errorCode, argument);
        this.noteLog(errorCode.getMsg(), apiName, argument);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemErrorException(Throwable cause) {
        super(cause);
    }

    protected SystemErrorException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    //记录error级日志
    private void noteLog(String message, String apiName, String argument) {
        logger.error(DateKit.getDateTimeStr(new Date()) + "-----------------> 参数:" + argument + "丨" + apiName + ":" + message, this);
    }
}
