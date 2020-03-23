package com.zhibinwang.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhibin.wang
 * @desc demo拦截器
 *
 **/
public class DemoInterceptor extends HandlerInterceptorAdapter {

    /**
     * 如果检查发现异常比如没有token可以抛出异常，通过全局异常处理类来返回json报文，
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

      response.getOutputStream().write(Integer.parseInt("12312"));
        return super.preHandle(request, response, handler);
    }
}
