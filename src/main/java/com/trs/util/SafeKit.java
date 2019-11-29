package com.trs.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:45
 */
public class SafeKit {

    public SafeKit() {
    }

    public static Integer getInteger(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Integer.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static Long getLong(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Long.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static Short getShort(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Short.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static Double getDouble(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Double.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static Float getFloat(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Float.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public static Boolean getBoolean(Object obj) {
        if (obj == null) {
            return null;
        } else {
            try {
                return Boolean.valueOf(obj.toString());
            } catch (Exception var2) {
                return null;
            }
        }
    }
    public static boolean isSpecialChar(String str) {
        String regEx = "[/:\\\\*\\\\?\\\\\\\"<>+.\\\\|]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    public static String getString(Object obj) {
        return obj == null ? null : obj.toString();
    }
}
