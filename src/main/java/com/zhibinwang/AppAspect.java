package com.zhibinwang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zhibin.wang
 * @create 2019-08-30 9:23
 * @desc
 **/
@SpringBootApplication
@EnableWebMvc
@EnableCaching
public class AppAspect {

    public static void main(String[] args) {
        SpringApplication.run(AppAspect.class,args);
    }
}
