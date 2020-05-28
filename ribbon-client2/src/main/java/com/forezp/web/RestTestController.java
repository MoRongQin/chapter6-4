package com.forezp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/6/13.
 */
@RestController
public class RestTestController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/testRest")
    public String testRest(){
        ServiceInstance instance = loadBalancerClient.choose("stores");
        return restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/blade-system/dept/detail?id=1123598813738675201",String.class);
    }

}
