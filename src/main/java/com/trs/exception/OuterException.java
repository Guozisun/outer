package com.trs.exception;

import com.trs.constants.SystemErrorCode;
import org.apache.log4j.Logger;

/**
 * Title:
 * Description: 系统异常父类
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:58
 */
public class OuterException extends Exception {
    protected Logger logger = Logger.getLogger(OuterException.class);

    private String desc;
    private SystemErrorCode errorCode;

    public OuterException() {
        super();
    }

    /**
     * 子类务必使用此构造来初始化错误码
     *
     * @param errorCode 错误码
     * @param argument  参数
     */
    public OuterException(SystemErrorCode errorCode, String argument) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
        this.desc = argument;
    }

    public OuterException(String message, Throwable cause) {
        super(message, cause);
    }

    public OuterException(Throwable cause) {
        super(cause);
    }

    protected OuterException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public SystemErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(SystemErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
