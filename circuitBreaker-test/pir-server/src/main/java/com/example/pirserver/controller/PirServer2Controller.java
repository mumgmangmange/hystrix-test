package com.example.pirserver.controller;

import com.example.pirserver.client.Demo1FeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class PirServer2Controller {

    private final Demo1FeignClient demo1FeignClient;

    @HystrixCommand
    @GetMapping("/test2")
    public String findById2() {
        String result = this.demo1FeignClient.demo1Test();
        log.info(">>> 호출함!!! {}", result);
        return "true";
    }
}
