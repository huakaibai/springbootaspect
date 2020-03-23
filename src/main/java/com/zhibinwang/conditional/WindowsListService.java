package com.zhibinwang.conditional;

/**
 * @author zhibin.wang
 * @desc
 **/
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
