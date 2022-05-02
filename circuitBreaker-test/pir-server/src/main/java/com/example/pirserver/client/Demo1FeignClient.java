package com.example.pirserver.client;

import com.example.pirserver.config.Demo1FeignConfig;
import com.example.pirserver.config.Demo1FeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8080",
        value = "demo1FeignClient",
        configuration = Demo1FeignConfig.class, // feign configuration 설정
        fallbackFactory = Demo1FeignFallbackFactory.class // 폴백 설정
)
public interface Demo1FeignClient {

    @GetMapping(value = "/demo-test")
    String demo1Test();
}
