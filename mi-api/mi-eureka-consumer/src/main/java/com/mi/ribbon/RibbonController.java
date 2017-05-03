package com.mi.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yesh
 *         (M.M)!
 *         Created by 2017/5/2.
 */
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/helloR",method = RequestMethod.GET)
    public String Hello(){
        return  restTemplate.getForEntity("http://MI-EUREKA-CLIENT/hi?name=Ribbon",String .class).getBody();
    }

}
