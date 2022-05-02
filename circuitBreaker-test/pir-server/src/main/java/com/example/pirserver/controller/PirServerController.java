package com.example.pirserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PirServerController {

    private final RestTemplate template;

    @GetMapping("/test")
    @HystrixCommand(fallbackMethod = "getFallback") // 아래의 fallback 메세지 호출
    public String findById() {
        String result = template.getForObject("http://localhost:8080/demo-test", String.class);
        log.info(">>> 호출함!!! {}", result);
        return "true";
    }

    public String getFallback() {
        return "[ getFallback !! ]";
    }
}
