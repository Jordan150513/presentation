package com.qiao.provider.controller;


import com.qiao.provider.common.BasicOut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/10 下午5:31
 * @Version 1.0
 **/
@RestController
//@RequestMapping("/provider/")
public class TestController {

    @RequestMapping("/provider/echo/")
    public String test(){
        BasicOut out = new BasicOut();
        out.setMessage("success");
        out.setReturnCode(0);
        return "Success";
    }
}
