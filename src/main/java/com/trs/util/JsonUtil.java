package com.trs.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 果子
 * Create Time:2019/10/21 20:27
 */
public class JsonUtil {
    public JsonUtil() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        T t = JSON.parseObject(json, clazz);
        return t;
    }

    public static String toJSONString(Object object) {
        String s = JSON.toJSONString(object);
        return s;
    }

    public static String toJSONString(Object object, boolean prettyFormat) {
        String s = JSON.toJSONString(object, prettyFormat);
        return s;
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        List<T> ts = JSON.parseArray(json, clazz);
        return ts;
    }
}
