package com.zhibinwang;

import org.springframework.stereotype.Service;

/**
 * @author zhibin.wang
 * @create 2019-08-30 9:19
 * @desc
 **/
@Service

public class WeiXinService {


    @CaculateExecuteTime
    public void share(String articleUrl){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("share  article"+articleUrl);
    }


    public void onebyone(){

        System.out.println("拥有全部的拦截器");
    }

}
