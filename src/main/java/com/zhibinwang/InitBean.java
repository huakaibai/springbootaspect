package com.zhibinwang;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author zhibin.wang
 * @desc 初始化bean
 **/
public class InitBean implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(   "InitBean 初始化完成" );
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitBean 对象被销毁");
    }
}
