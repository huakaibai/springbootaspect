package com.zhibinwang.mvc;

import com.zhibinwang.converter.MyMessageConverter;
import com.zhibinwang.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * @author zhibin.wang
 * @desc mvc 配置
 **/
@Configuration


public class MyMvcConfig extends WebMvcConfigurationSupport {



    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalResourceView = new InternalResourceViewResolver();
        internalResourceView.setPrefix("WEB-INF/classes/views/");
        viewResolver().setSuffix(".jsp");
        viewResolver().setViewClass(JstlView.class);
        return viewResolver();
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(demoInterceptor());
    }

    @Bean
    public MyMessageConverter myMessageConverter(){
        return new MyMessageConverter();
    }
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myMessageConverter());
    }
}
