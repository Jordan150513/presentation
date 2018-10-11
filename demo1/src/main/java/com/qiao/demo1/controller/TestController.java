package com.qiao.demo1.controller;


import com.qiao.demo1.common.BasicOut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/10 下午5:31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("echo")
    public Object test(){
        BasicOut out = new BasicOut();
        out.setMessage("success");
        out.setReturnCode(0);
        return out;
    }
}
