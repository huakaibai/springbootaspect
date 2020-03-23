package com.zhibinwang.anntion;

import org.springframework.stereotype.Service;

/**
 * @author zhibin.wang
 * @desc
 **/
@Service
public class DemoService {

    public String outputResult(){
        System.out.println("从组合注解配置照样活得bean");
        return "demotest";
    }
}
