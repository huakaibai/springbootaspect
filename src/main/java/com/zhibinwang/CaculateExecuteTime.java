package com.zhibinwang;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhibin.wang
 * @create 2019-09-02 10:04
 * @desc 自定义注解
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CaculateExecuteTime {
}
