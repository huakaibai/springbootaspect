package com.zhibinwang.conditional;

/**
 * @author zhibin.wang
 * @desc
 **/
public class LinuxListService implements  ListService {
    @Override
    public String showListCmd() {
        return "list";
    }
}
