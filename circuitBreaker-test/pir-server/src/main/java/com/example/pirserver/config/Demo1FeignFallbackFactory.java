package com.example.pirserver.config;

import com.example.pirserver.client.Demo1FeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Demo1FeignFallbackFactory implements FallbackFactory<Demo1FeignClient> {

    public Demo1FeignClient create(Throwable cause) {
        log.info(">>>> fallback call");
        return new Demo1FeignClient() {
            @Override
            public String demo1Test() {
                return ">>>> fallback call";
            }
        };
    }
}
