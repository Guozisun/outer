package com.trs.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * Title:
 * Description: 后台加解密
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:14
 */
public class SecretUtil {

    /**
     * 解密
     *
     * @param requestId 请求唯一标识
     * @param timestamp 时间戳
     * @param salt      盐值
     * @return
     * @throws Exception
     */
    public static String decrypt(String requestId, String timestamp, String salt) {
        StringBuilder stringBuilder = new StringBuilder("").append("requestId:")
                .append(requestId).append("timeStamp:").append(timestamp)
                .append("salt:").append(salt);
        return encodeMD5Hex(stringBuilder.toString());
    }


    private static String encodeMD5Hex(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes("UTF-8"));
            return Hex.encodeHexString(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("").append("requestId:")
                .append("122222").append("timeStamp:").append("222")
                .append("salt:").append("0fdfa5e5a88bebae640a5d88e7c84708");
        System.out.println(encodeMD5Hex(stringBuilder.toString()));
    }
}
