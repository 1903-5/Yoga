package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ：BinSun
 * @date : 2019/8/20 22:03
 * @description :
 * @modified By ：
 * @version:
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class yogaStudentHomePageApplication {
    public static void main(String[] args) {
        SpringApplication.run(yogaStudentHomePageApplication.class,args);
    }

}
