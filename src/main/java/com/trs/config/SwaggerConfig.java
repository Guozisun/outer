package com.trs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Title:
 * Description:swagger文档配置文件
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 17:34
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class) //
                .useDefaultResponseMessages(false) //
                .forCodeGeneration(true) //
                .apiInfo(getApiInfo()) //
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select() //
                .apis(RequestHandlerSelectors.basePackage("com.trs.web"))
                .paths(PathSelectors.any()) //
                .build(); //
    }
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("图片库Swagger文档") // 标题
                .description("图片库Swagger文档") // 描述信息
                .version("1.1.2") // //版本
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

}
