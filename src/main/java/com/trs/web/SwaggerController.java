package com.trs.web;

import com.trs.api.SwaggerControllerApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:swagger 测试类
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 17:42
 */
@RequestMapping("swaggerController")
@RestController
public class SwaggerController implements SwaggerControllerApi {


    @Override
    @PostMapping("testSwagger")
    public String testSwagger(String title, String name) {

        return title + "_" + name;
    }
}
