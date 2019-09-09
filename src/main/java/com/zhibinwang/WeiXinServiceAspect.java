package com.zhibinwang;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhibin.wang
 * @create 2019-08-30 9:44
 * @desc
 **/
@Component
@Aspect //标记为一个切面
public class WeiXinServiceAspect {


    /**
     * execution 该指示器用来匹配方法执行连接点，即匹配哪个方法执行
     * within     如果要匹配一个类中所有方法的调用，便可以使用 within 指示器 还可以匹配某个包下面的所有类的所有方法调用
     * target 如果目标对象实现了任何接口，Spring AOP 会创建基于CGLIB 的动态代理，这时候需要使用 target 指示器
     * this  如果目标对象没有实现任何接口，Spring AOP 会创建基于JDK的动态代理，这时候需要使用 this 指示器
     * @target 该指示器用于匹配连接点所在的类是否拥有指定类型的注解,注意是所在类
     * @annotation 匹配连接点的某个方法是否有某个注解
     */

    @Pointcut("execution(public void WeiXinService.share(String))") //定义切点
    public void shareCut(){

    }


    @Pointcut("within(com.zhibinwang.WeiXinService)") //定义切点
    public void shareCutAll(){

    }

    @Pointcut("@annotation(CaculateExecuteTime)")
    public void shareAnntion(){}


    /**
     * @AfterReturing：该 Advice 会在方法正常返回以后执行
     * @AfterThrowing： 该 Advice 会在方法抛出异常以后执行
     * @After： 该 Advice 无论如何，在方法执行以后都会执行
     * @param joinPoint
     */

    @AfterReturning("shareCut()") //在业务运行后执行
    public void log(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature()+" executed");

    }

    @Before("shareCutAll()")
    public void log2(JoinPoint joinPoint){
        System.out.println(WeiXinService.class.getName()+"这个类的方法执行前全部被拦截");
    }


    @Around("shareAnntion()")
    public void arround(ProceedingJoinPoint joinPoint){
        long l = System.currentTimeMillis();
        try{        Object proceed = joinPoint.proceed();}catch (Exception e){} catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("消耗时间="+(System.currentTimeMillis() - l));
    }

}
