package com.consumer.myribbon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@RestController
//public class HelloConsumerController {
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @GetMapping("/helloworld")
//    public String helloWorld() {
//        return restTemplate.getForEntity("http://RIBBON-SERVICE/hello",String.class).getBody();
//    }
//}
//


@RestController
public class HelloConsumerController {

    @Autowired
    RestTemplate restTemplate;


    /**
     * 服务端熔断请求的方法
     * @return
     */
    @GetMapping("/helloworld/hystrix")
    public String hystrixHelloWorld() {
        return restTemplate.getForEntity("http://RIBBON-SERVICE/hello/hystrix",String.class).getBody();
    }
}
