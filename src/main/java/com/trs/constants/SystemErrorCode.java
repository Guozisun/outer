package com.trs.constants;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:异常常量类
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:54
 */
public enum SystemErrorCode {

    SYSTEM_ERROR("-1001", "System error", "系统错误"),
    PARAM_ERROR("-1002", "Arguments error", "参数错误"),
    TENANT_ERROR("-1003", "Arguments error", "租户信息不正确"),
    UPLOAD_ERROR("-1004","Upload error","上传文件错误"),
    PATH_ERROR("-1005","Path error","文件路径为空");

    SystemErrorCode(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public String toString() {
        return getCode() + ":" + getMsg();
    }

    /**
     * 错误信息封装为map
     *
     * @return map对象
     */
    @SuppressWarnings(value = "all")
    public Map<String, Object> toMap(String desc) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("ErrorCode", getCode());
        resultMap.put("ErrorMsg", getMsg());
        resultMap.put("ErrorDesc", StringUtils.isEmpty(desc) ? getDesc() : desc);
        return resultMap;
    }

    private String code;
    private String msg;
    private String desc;

    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    private void setDesc(String desc) {
        this.desc = desc;
    }
}
