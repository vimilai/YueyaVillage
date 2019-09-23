package com.base;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//,fallback = HelloRemoteHystrix.class
@FeignClient(name= "yyc-service")
public interface HelloRemote {
    @RequestMapping(value = "/point/getRankTop10")
    public ResultMessage getRankTop10();
}