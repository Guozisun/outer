package com.trs.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Title:
 * Description: 后台接口controller标识
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 20:39
 */
@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
public @interface ApiCenter {
}
