package com.base;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "yyc-service")
public interface HelloRemote {
    @RequestMapping(value = "/point/getRankTop10")
    public ResultMessage getRankTop10();
}