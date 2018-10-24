package com.qiao.demo1.controller;


import com.qiao.demo1.common.BasicOut;
import com.qiao.demo1.feign.ProviderFeign;
import com.qiao.demo1.service.ConsumerService;
import com.qiao.demo1.service.ConsumerService2;
import com.qiao.demo1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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


    @Autowired
    private ConsumerService2 consumerService2;
    @Autowired
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)
    public String testFeign(){
        return testService.test();
    }

    @Value("${name}")
    private String name;

    @RequestMapping(value = "fetchName",method = RequestMethod.GET)
    public String fetchName(){
        return this.name + " from client-provider-2-user";
    }

    @RequestMapping("consumer")
    public Object consumer(){
        String rs = "";
        for (int i=0;i<100;i++){
             rs =  consumerService2.consumerByFeign();
        }
       return rs;
    }

    @RequestMapping("ribbon/consumer")
    @LoadBalanced
    public Object ribbonConsumer(){
        String url = "http://microservice-providerdemo/provider/echo/";
        String rs = restTemplate.getForObject(url,String.class);
        return rs;
    }


}
