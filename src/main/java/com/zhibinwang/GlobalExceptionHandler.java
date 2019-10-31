package com.zhibinwang;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 *  整合全局异常处理，包含运行异常，参数校验异常
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public String exceptionHandler(Exception e) {
		log.info("###全局捕获异常###,error:{}", e);
		return "系统错误";
	}
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public java.lang.String handler( BindException ex){
		StringBuilder sb = new StringBuilder();
		FieldError fieldError = ex.getFieldError();
		sb.append(fieldError.getDefaultMessage());
		System.out.println(sb.toString());
		return sb.toString();
	}

/*	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public java.lang.String handler(HttpServletRequest request, ConstraintViolationException ex){
		StringBuilder sb = new StringBuilder();
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			sb.append(constraintViolation.getMessage());
		}
		System.out.println(sb.toString());
		return sb.toString();
	}*/
}