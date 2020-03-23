package com.zhibinwang.anntion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author zhibin.wang
 * @create 2020-01-14 16:47
 * @desc 自定义元注解
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface ZhiBinConfig {

    String[] value() default {}; //覆盖value参数
}
