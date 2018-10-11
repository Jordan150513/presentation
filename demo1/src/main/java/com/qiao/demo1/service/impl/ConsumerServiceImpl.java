package com.qiao.demo1.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiao.demo1.common.BasicOut;
import com.qiao.demo1.feign.ProviderFeign;
import com.qiao.demo1.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Auther qiaodan
 * @Date 2018/10/11 下午2:00
 * @Version 1.0
 **/
@Repository
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired(required = false)
    private ProviderFeign providerFeign;


    @Override
    @HystrixCommand(defaultFallback = "feignFallback")
    public String consumerByFeign(){
        return providerFeign.echo();
    }


    public BasicOut feignFallback(){
        BasicOut out = new BasicOut();
        out.setMessage("调用feign失败的fallback");
        out.setReturnCode(-1);
        return out;
    }

}
