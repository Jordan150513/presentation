package com.qiao.provider.controller;


import com.qiao.provider.common.BasicOut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/10 下午5:31
 * @Version 1.0
 **/
@RestController
@RefreshScope
@RequestMapping("/test/")
public class TestController {

    @Value("${server.port}")
    private String portName;

    @RequestMapping("echo")
    public String test(){
        BasicOut out = new BasicOut();
        out.setMessage("success");
        out.setReturnCode(0);
        return "Success "+portName;
    }

    @Value("${name}")
    private String name;

    @RequestMapping(value = "fetchName",method = RequestMethod.GET)
    public String fetchName(){
        return this.name;
    }

}
