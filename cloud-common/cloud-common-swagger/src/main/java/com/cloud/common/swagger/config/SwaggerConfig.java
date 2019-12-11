package com.cloud.common.swagger.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger实现
 * @author Aijm
 * @since 2019/7/14
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true )
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.cloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hcloud 微服务架构")
                .description("Hcloud 微服务架构 操作文档")
                //服务条款网址
                .termsOfServiceUrl("http://www.eduvipx.cn/")
                .version("1.0")
                .contact(new Contact("Hcloud", "http://www.eduvipx.com/", "jxaijm94@163.com"))
                .build();
    }
}
