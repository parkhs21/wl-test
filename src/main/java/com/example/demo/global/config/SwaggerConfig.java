package com.example.demo.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("WL-Test API")
                .description("인턴십 과제 API Swagger 문서입니다.")
                .version("v1.0");

        return new OpenAPI()
                .info(info);
    }
}