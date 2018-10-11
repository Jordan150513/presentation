package com.qiao.demo1.feign;

import com.qiao.demo1.common.BasicOut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//@FeignClient(name = "microservice-account-wallet")
@FeignClient(name = "microservice-providerdemo")
public interface ProviderFeign {

//    @RequestMapping(value = "/wallet/ChargeController/chargeForUser",method = RequestMethod.GET)
//    public String chargeForUser();
    @RequestMapping(value = "/provider/echo/",method = RequestMethod.GET)
    public String echo();
}

