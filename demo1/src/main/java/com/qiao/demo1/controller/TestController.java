package com.qiao.demo1.controller;


import com.qiao.demo1.common.BasicOut;
import com.qiao.demo1.feign.ProviderFeign;
import com.qiao.demo1.service.ConsumerService;
import com.qiao.demo1.service.ConsumerService2;
import com.qiao.demo1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test/")
public class TestController {

//    @Autowired
//    private ConsumerService consumerService;
    @Autowired
    private ConsumerService2 consumerService2;
    @Autowired
    private TestService testService;
    //  localhost:8877/TestController/testFeign/
    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)

    public String testFeign(){
        return testService.test();
    }

    @RequestMapping("echo")
    public Object test(){
        BasicOut out = new BasicOut();
        out.setMessage("success");
        out.setReturnCode(0);
        return out;
    }

    @RequestMapping("consumer")
    public Object consumer(){
        String rs = "";
        for (int i=0;i<100;i++){
             rs =  consumerService2.consumerByFeign();
        }
       return rs;
    }
}
