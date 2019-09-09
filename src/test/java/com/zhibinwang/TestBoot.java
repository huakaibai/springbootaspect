package com.zhibinwang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhibin.wang
 * @create 2019-08-30 9:41
 * @desc
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AppAspect.class})
public class TestBoot {


    @Autowired
    ApplicationContext context;



    @Test
    public void test(){
        WeiXinService bean = context.getBean(WeiXinService.class);
        bean.share("baidu");
    }

}
