package com.trs.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description: 加密配置文件
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 19:25
 */
@ConfigurationProperties(prefix = SecretProperties.PREFIX)
@Component
public class SecretProperties {
    public static final String PREFIX = "secretsalt";

    private String salt = "0fdfa5e5a88bebae640a5d88e7c84708";

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
