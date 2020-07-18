package com.spring.demo.aspect;

import javax.validation.ConstraintViolationException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.spring.demo.exception.DuplicateCustidException;


@Component
@Aspect
@Order(100)
public class DataAccessServiceAspect {
	
	@Before("execution(* com.spring.demo.service.*.*(..))")
	public void logBefore(){
		System.out.println("@Before:"+new java.util.Date());
	}
	
	
	@AfterThrowing(value="execution(* com.spring.demo.service.*.*(..))",throwing = "ex")
	public void handleDataAccessException(Throwable ex) {
		System.out.println("The class name is "+ex.getClass());
		if(ex instanceof DataIntegrityViolationException) {
			 throw new DuplicateCustidException("Custid Already Exist");
		}
	}

}
