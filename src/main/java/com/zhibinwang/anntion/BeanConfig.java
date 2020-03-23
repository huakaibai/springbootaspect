package com.zhibinwang.anntion;

import com.zhibinwang.InitBean;
import com.zhibinwang.config.BeanWayService;
import com.zhibinwang.config.Jsr250WayService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhibin.wang
 * @desc
 **/

public class BeanConfig {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        DemoService bean = context.getBean(DemoService.class);
        bean.outputResult();
        context.close();
    }
}
