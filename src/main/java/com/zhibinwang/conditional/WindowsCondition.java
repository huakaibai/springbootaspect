package com.zhibinwang.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author zhibin.wang
 * @desc windows 定义条件
 **/
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean windows = context.getEnvironment().getProperty("os.name").contains("Windows");
        return windows ;
    }
}
