package com.trs.Interceptor;

import com.trs.aop.ApiCenter;
import com.trs.constants.OuterConstans;
import com.trs.constants.SecretProperties;
import com.trs.constants.SystemErrorCode;
import com.trs.exception.SystemErrorException;
import com.trs.util.SafeKit;
import com.trs.util.SecretUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Title:
 * Description:后台接口校验拦截器
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:02
 */
@Component
public class ApiSecretInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(ApiSecretInterceptor.class);

    @Autowired
    private SecretProperties secretProperties;


    /**
     * preHandle
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果是swagger 不校验
        String refererStr = request.getHeader("Referer");
        if (refererStr != null && refererStr.contains("swagger-ui")) {
            return true;
        }
        try {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //如果是带有ApiCenter注解的controller不进行拦截
            if (handlerMethod.getBeanType().isAnnotationPresent(ApiCenter.class)) {
                return true;
            }
        }catch (Exception e){

        }
        //每个后台方法必带的requestId
        String requestId = SafeKit.getString(request.getParameter(OuterConstans.REQUESTID));
        //每个后台方法必带的时间戳
        String timeStemp = SafeKit.getString(request.getParameter(OuterConstans.TIMESTEMP));
        String token = SafeKit.getString(request.getParameter(OuterConstans.TOKEN));
        if (StringUtils.isEmpty(requestId)) {
            throw new SystemErrorException(SystemErrorCode.PARAM_ERROR, "ApiSecretInterceptor", "接口解密请求id为空");
        }
        if (StringUtils.isEmpty(timeStemp)) {
            throw new SystemErrorException(SystemErrorCode.PARAM_ERROR, "ApiSecretInterceptor", "接口解密时间戳为空");
        }
        if (StringUtils.isEmpty(token)) {
            throw new SystemErrorException(SystemErrorCode.PARAM_ERROR, "ApiSecretInterceptor", "接口解密token为空");
        }
        String now = SafeKit.getString(new Date().getTime());
        //请求url
        String requestUrl = request.getRequestURI();
        //参数字符串拼接
        StringBuilder paramStr = new StringBuilder();
        logger.error("print by zyf --> url:" + requestUrl + ",uuid:" + requestId.toString() + ",time:" + now +
                ",params:" + paramStr.toString());
        //进行校验
        String deToken = SecretUtil.decrypt(requestId, timeStemp, secretProperties.getSalt());
        if (StringUtils.isEmpty(deToken)) {
            throw new SystemErrorException(SystemErrorCode.SYSTEM_ERROR, "ApiSecretInterceptor", "解密失败");
        }
        if (deToken.equals(token)) {
            return true;
        }
        //其它情况都无权限
        throw new SystemErrorException(SystemErrorCode.SYSTEM_ERROR, "ApiSecretInterceptor", "调用方法解密失败,url:" + requestUrl);
    }


    /**
     * 后置处理
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 请求完成后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
