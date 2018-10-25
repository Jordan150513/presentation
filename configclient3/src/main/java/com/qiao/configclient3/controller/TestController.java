package com.qiao.configclient3.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaodan on 2017/7/7.
 */
@RestController
@RefreshScope
@RequestMapping("/test/")
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping(value = "fetchName",method = RequestMethod.GET)
    public String fetchName(){
     return this.name + "from client-provider-1-user";
    }

    @RequestMapping(value = "getName",method = RequestMethod.GET)
    public String getUser(){
        return "from client-provider-1-user";
    }

}

