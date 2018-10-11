package com.qiao.demo1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiao.demo1.common.BasicOut;
import com.qiao.demo1.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/11 下午2:18
 * @Version 1.0
 **/
@Service
public class ConsumerService2 {
    @Autowired(required = false)
    private ProviderFeign providerFeign;


    @HystrixCommand(defaultFallback = "feignFallback")
    public String consumerByFeign(){
        System.out.println("feign调用");
        return providerFeign.echo();
    }


    public String feignFallback(){
        BasicOut out = new BasicOut();
        out.setMessage("调用feign失败的fallback");
        out.setReturnCode(-1);
        System.out.println("调用feign失败的fallback");
        return "fail";
    }
}
