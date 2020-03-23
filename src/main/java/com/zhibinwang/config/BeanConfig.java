package com.zhibinwang.config;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zhibinwang.InitBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhibin.wang
 * @desc
 **/
@Configuration
public class BeanConfig {

    @Bean
    public InitBean initBean(){
        return  new InitBean();
    }


    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    public  Jsr250WayService jsr250WayService(){
        return new Jsr250WayService();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        context.getBean(InitBean.class);
        context.getBean(BeanWayService.class);
        context.getBean(Jsr250WayService.class);
        context.close();
    }
}
