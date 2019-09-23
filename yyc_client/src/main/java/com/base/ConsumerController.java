package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloRemote helloRemote;
	
    @RequestMapping("/getRankTop10")
    public ResultMessage index() {
        return (ResultMessage) helloRemote.getRankTop10();
    }

}