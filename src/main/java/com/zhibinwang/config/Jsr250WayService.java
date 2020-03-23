package com.zhibinwang.config;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhibin.wang
 * @desc
 **/
public class Jsr250WayService {

    @PostConstruct
    public void init(){
        System.out.println("Jsr250WayService method init");
    }


    @PreDestroy
    public void destroy(){
        System.out.println("Jsr250WayService method destroy");
    }
}
