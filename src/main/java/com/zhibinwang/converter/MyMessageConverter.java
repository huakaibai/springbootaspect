package com.zhibinwang.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author zhibin.wang
 * @desc 自定义消息转换器
 **/
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] split = temp.split(("-"));
        return new DemoObj(split[0],split[1]);

    }

    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:"+demoObj.getKey()+"-"+demoObj.getVlaue();
        httpOutputMessage.getBody().write(out.getBytes("UTF-8"));
    }
}
