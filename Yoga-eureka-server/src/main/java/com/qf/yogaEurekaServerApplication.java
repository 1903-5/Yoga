package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaServer//开启eurekaserver,会自动帮我们配置
public class yogaEurekaServerApplication {
    public static void main(String[] args) {
       SpringApplication.run(yogaEurekaServerApplication.class,args);
    }
}