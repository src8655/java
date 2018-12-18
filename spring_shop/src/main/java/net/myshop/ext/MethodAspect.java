package net.myshop.ext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodAspect {
	@Before("execution(* net.myshop.controller.*Controller.*(..))")
	public void before(JoinPoint jp){
		
        System.out.println("�޼��� ����:"+jp.getSignature());
        
        Object[] ob = jp.getArgs();
        for(int i=0;i<ob.length;i++) System.out.println(""+ob[i]);
    }
}
