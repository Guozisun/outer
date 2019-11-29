package com.trs;

import com.trs.Interceptor.ApiSecretInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
public class OuterApplication  implements WebMvcConfigurer   {
    @Autowired
    private ApiSecretInterceptor apiSecretInterceptor;
    public static void main(String[] args) {
        SpringApplication.run(OuterApplication.class, args);
    }
    /**
     * 加载拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 配置以后 excludePathPatterns才会生效
        registry.addInterceptor(apiSecretInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html");
    }
}
