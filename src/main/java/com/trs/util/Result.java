package com.trs.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 果子
 * Create Time:2019/10/21 19:02
 */
@ApiModel
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4569216979022946969L;
    @ApiModelProperty(
            notes = "返回数据",
            required = true
    )
    private T data;
    @ApiModelProperty(
            notes = "成功标识",
            example = "true",
            required = true
    )
    private boolean isSuccess = false;
    @ApiModelProperty(
            notes = "结果信息",
            example = "执行成功！",
            required = true
    )
    private String resultMsg = "执行失败!";
    private String DETAIL = "";
    public Result() {
    }

    public static Result fail() {
        return new Result();
    }

    public static Result fail(String msg) {
        Result result = fail();
        result.setResultMsg(msg);
        return result;
    }

    public static Result success(String msg) {
        Result result = success();
        result.setResultMsg(msg);
        return result;
    }

    public static Result fails(String msg) {
        Result result = new Result();
        result.setResultMsg("");
        result.setData(null);
        result.setIsSuccess(false);
        return result;
    }
    public static Result successs(String msg) {
        Result result =new Result();
        result.setResultMsg("");
        result.setData(null);
        result.setIsSuccess(true);
        return result;
    }


    public static Result success() {
        return success(new Result());
    }

    public static Result success(Result result) {
        if (result == null) {
            result = new Result();
        }

        result.setResultMsg("执行成功！");
        result.setIsSuccess(true);
        return result;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getDETAIL() {
        return DETAIL;
    }

    public void setDETAIL(String DETAIL) {
        this.DETAIL = DETAIL;
    }


    public String toString() {
        return JSON.toJSONString(this, new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect});
    }

    public Result addData(String key, Object value) throws Exception {
        Object map;
        if (this.data == null) {
            map = new HashMap();
        } else {
            if (!(this.data instanceof Map)) {
                throw new Exception("not support");
            }

            map = (Map)this.data;
        }

        ((Map)map).put(key, value);
        this.setData((T) map);
        return this;
    }

    public Result removeData(String... keys) {
        if (this.data != null && this.data instanceof Map) {
            Map<String, Object> map = (Map)this.data;
            String[] var3 = keys;
            int var4 = keys.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String key = var3[var5];
                map.remove(key);
            }

            return this;
        } else {
            return this;
        }
    }

    public Result clearData() {
        this.data = null;
        return this;
    }

    public Object get(String key) {
        if (this.data != null && !StringUtils.isEmpty(key) && this.data instanceof Map) {
            Map<String, Object> map = (Map)this.data;
            return map.get(key);
        } else {
            return null;
        }
    }
    public String getString(String key) {
        return SafeKit.getString(this.get(key));
    }

    public Integer getInteger(String key) {
        return SafeKit.getInteger(this.get(key));
    }

    public Long getLong(String key) {
        return SafeKit.getLong(this.get(key));
    }

    public Double getDouble(String key) {
        return SafeKit.getDouble(this.get(key));
    }

    public Boolean getBoolean(String key) {
        return SafeKit.getBoolean(this.get(key));
    }

}
