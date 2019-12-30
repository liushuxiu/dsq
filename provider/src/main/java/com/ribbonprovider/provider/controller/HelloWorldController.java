package com.ribbonprovider.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HelloWorldController
 * @Description TODO
 * @Author Neal
 * @Date 2019/3/25 10:49
 * @Version 1.0
 */
@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private String port;

    /**
     * 随机数生成类
     */
    private static Random random = new Random();

    /**
     * 基于服务端的熔断策略实现
     * @return
     * @throws InterruptedException
     */
    @HystrixCommand(
            commandProperties = {
                    //设置单线程请求的超时时间，如果超时，回调方法
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
            },
            fallbackMethod = "fallBackHelloWorld"
    )
    @GetMapping("/hello/hystrix")
    public String hystrixHelloWorld() throws InterruptedException {
        long executeTime = random.nextInt(200);
        System.out.println("execute Time : " + executeTime);
        TimeUnit.MILLISECONDS.sleep(executeTime);
        return "Hello World from port:" + port;
    }

    /**
     * 熔断策略的回调方法
     * @return
     */
    public String fallBackHelloWorld() {
        return "@HystrixCommand : Time out 100 ms";
    }
}
