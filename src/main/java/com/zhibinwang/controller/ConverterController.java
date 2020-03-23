package com.zhibinwang.controller;

import com.zhibinwang.converter.DemoObj;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhibin.wang
 * @desc
 **/
@RestController
public class ConverterController {

    @RequestMapping(value = "/convert",produces = "application/a-wangzhibin")
    public DemoObj convert(@RequestBody DemoObj demoObj){
        demoObj.setKey(demoObj.getKey()+"ss");
        return  demoObj;
    }
}
