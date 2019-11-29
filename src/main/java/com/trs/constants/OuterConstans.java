package com.trs.constants;

/**
 * Title:
 * Description: 工程常量
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:36
 */
public class OuterConstans {

    /**
     * 后台每个接口必传的加密时间戳
     */
    public static final String TIMESTEMP = "timeStamp";

    /**
     * 加密盐值
     */
    public static final String SALT = "salt";

    /**
     * 后台每个请求必传的请求id
     */
    public static final String REQUESTID = "requestId";

    /**
     * 后台每个请求必传的请求标签
     */
    public static final String SINGNATURE = "signature";

    /**
     * 后台每个接口必传的加密时间戳
     */
    public static final String TIMESTEMPS = "timestamp";

    /**
     * 加密盐值
     */
    public static final String SMSSALT = "2ba270a113638913eb00990ca88882e5";

    /**
     * 后台每个请求必传的token
     */
    public static final String TOKEN = "token";
    /**
     * 支持的图片类型
     */
    public static final String PICTYPE=".bmp,.jpg,.png,.tif,.gif,.pcx,.tga,.exif,.fpx,.svg,.psd,.cdr,.pcd,.dxf,.ufo,.eps,.ai,.raw,.WMF,.webp";

    /**
     * 缩略图宽度
     */
    public static final Integer TOWIDTH=392;
    /**
     * 缩略图长度
     */
    public static final Integer TOHIGTH=223;
    public static final Long LENGTH= Long.valueOf(10*1024*1024);
    public static final Double EQUALRATIO= Double.valueOf(392.0/223.0);
    //数字报 metidiaId
    public static final String []SZBIDS = {"szb2"};
    //数字报 bc板块id
    public static final String []BMTBC={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23",
            "24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55"};



}
