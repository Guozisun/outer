package com.trs.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Title:
 * Description: 大数据获取三个接口工具类
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 果子
 * Create Time:2019/10/25 20:14
 */
public class PortUtil {
    //日志
    private static Logger logger = LoggerFactory.getLogger(PortUtil.class);


    /**
     * 获取BmtUrl及参数
     *
     * @param urlLink
     * @param bmtId
     * @param dataString
     * @return
     */
    public static String getBody(String urlLink, String bmtId, String dataString) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("mediaId", bmtId);
        form.add("typeName", "szb");
        form.add("pageSize", 12);
        form.add("pageNum", 1);
        form.add("keyword", "{\"time\":\"" + dataString + "," + dataString + "\"}");
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> fileMap = new HttpEntity<>(form, headers);
        String bmtData = "";
        try {
            bmtData = restTemplate.postForObject(urlLink, fileMap, String.class);
        } catch (Exception e) {
            logger.error("访问大数据bmt接口出错!");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(bmtData);
        logger.info("print by scg :时间为："+dataString+"mediaId为："+bmtId+"-是否成功："+ jsonObject.getString("result"));
        if (jsonObject.getString("result").equalsIgnoreCase("success")){
            JSONArray jsonArray = jsonObject.getJSONArray("content");
            logger.info("长度为"+jsonArray.size()+"条");
        }
        return bmtData;

    }

    /**
     * 获取MenuUrl及参数
     *
     * @param urlLink
     * @param pubTime
     * @param mediaId
     * @return
     */
    public static String getBodyMenu(String urlLink, String pubTime, String mediaId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("mediaId", mediaId);
        form.add("docpubtime", pubTime);
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> fileMap = new HttpEntity<>(form, headers);
        String menuData = "";
        try {
            menuData = restTemplate.postForObject(urlLink, fileMap, String.class);
        } catch (Exception e) {
            logger.error("访问大数据Menu接口出错!");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(menuData);
        logger.info("print by scg :时间为："+pubTime+"mediaId为："+mediaId+"-是否成功："+ jsonObject.getString("result"));
        if (jsonObject.getString("result").equals("success")){
            JSONArray jsonArray = jsonObject.getJSONArray("content");
            if (jsonArray!=null) {
                JSONArray jsonArray1 = jsonArray.getJSONArray(0);
                logger.info("成功后数据包含"+jsonArray1.size()+"条");
            }
        }
        return menuData;

    }

    /**
     * 获取Formalurl及参数
     *
     * @param urlLink
     * @param pubTime
     * @param mediaId
     * @param bmPc
     * @return
     */
    public static String getBodyFomal(String urlLink, String pubTime, String mediaId, String bmPc) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("mediaId", mediaId);
        form.add("docpubtime", pubTime);
        form.add("bc", bmPc);
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> fileMap = new HttpEntity<>(form, headers);
        String formalData = "";
        try {
            formalData = restTemplate.postForObject(urlLink, fileMap, String.class);
        } catch (Exception e) {
            logger.error("访问大数据Formal接口出错!");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(formalData);
        logger.info("print by scg :时间为："+pubTime+"-mediaId:"+mediaId+"-是否成功："+ jsonObject.getString("result")+"版次号为："+bmPc);
        if (jsonObject.getString("result").equalsIgnoreCase("success")){
            JSONArray jsonArray = jsonObject.getJSONArray("content");
            logger.info("长度为"+jsonArray.size()+"条");
        }
        return formalData;
    }
    public static String getDetailData(String urlLink, String guId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("guid", guId);
        form.add("channalName","szb");
        form.add("indexName", "szb_formal;product_formal");
        //用HttpEntity封装整个请求报文
        HttpEntity<MultiValueMap<String, Object>> fileMap = new HttpEntity<>(form, headers);
        String formalData = "";
        try {
            formalData = restTemplate.postForObject(urlLink, fileMap, String.class);
        } catch (Exception e) {
            logger.error("访问大数据Formal接口出错!");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(formalData);
        logger.info("print by scg :GUID为："+guId+"是否成功："+ jsonObject.getString("result"));
        if (jsonObject.getString("result").equalsIgnoreCase("success")){
            JSONArray jsonArray = jsonObject.getJSONArray("content");
            logger.info("长度为"+jsonArray.size()+"条");
        }
        return formalData;
    }


}
