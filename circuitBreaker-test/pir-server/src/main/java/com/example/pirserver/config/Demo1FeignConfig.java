package com.example.pirserver.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Demo1FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            log.info("requestTemplate.path():{}", requestTemplate.path());
            log.info("requestTemplate.request().headers():{}", requestTemplate.request().headers());
        };
    }
}
