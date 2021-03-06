package com.SeventhGroup.CollegeSearchJob.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).host("60.205.224.10/lw-api").protocols(Collections.singleton("http")).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build().apiInfo(this.apiInfo());
       //host("60.205.224.10/lw-api").protocols(Collections.singleton("http")).
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("CollegeSearchJob")
                .description("CollegeSearchJob接口")
                .version("1.0")
                .build();
    }


}
