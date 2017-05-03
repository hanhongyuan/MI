package com.mi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/2.
 */
@RestController
public class ApiController {

    private final Logger log = Logger.getLogger(ApiController.class);

    String port="1001";

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hi")
    public String hello(@RequestParam String name){
        System.err.println("-----------------------------");
        ServiceInstance instance = discoveryClient.getInstances("mi-eureka-client-api").get(0);

        log.info("Method:---->"+this.getClass().getSimpleName()+"---->Hello");
        log.info("Url:---->"+instance.getUri());
        log.info("Host:---->"+instance.getHost());
        log.info("Port:---->"+instance.getPort());

        return "hello"+name + " ,i here in port :" +port;
    }
}
