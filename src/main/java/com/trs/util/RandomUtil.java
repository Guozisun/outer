package com.trs.util;

import java.util.Random;

public class RandomUtil {

    /**
     * Description: 根据传入的长度生成随机字符串0-9<BR>
     *
     * @param length 字符串长度
     * @return
     * @version 1.0
     */
    public static final String NUMChar = "0123456789";
    public static String generateNumStr(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(NUMChar.charAt(random.nextInt(NUMChar.length())));
        }
        return sb.toString();
    }
}
