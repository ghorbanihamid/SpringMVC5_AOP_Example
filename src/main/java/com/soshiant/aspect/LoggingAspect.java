package com.soshiant.aspect;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {

    private Logger logger = LogManager.getRootLogger();


    @Before(value = "execution(* com.soshiant.service.welcome.WelcomeService.getGuestWelcomeMessage(..))")
    public void logBeforeWelcome(JoinPoint joinPoint) {

        logger.info(" LoggingAspect,WelcomeService, @Before: Before Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @After(value = "execution(* com.soshiant.service.welcome.WelcomeService.getGuestWelcomeMessage(..))")
    public void logAfterWelcome(JoinPoint joinPoint) {

        logger.info(" LoggingAspect,WelcomeService, @After: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @Around("execution(* com.soshiant.service.welcome.*.*(..))")
    public void logAroundWelcome(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,WelcomeService, @Around: Before Running Method "+ joinPoint.getSignature().getName() + "===");
        joinPoint.proceed();
        logger.info(" LoggingAspect,WelcomeService, @Around: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @AfterReturning("execution(* com.soshiant.service.welcome.*.*(..))")
    public void logAfterReturningWelcome(JoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,WelcomeService, @AfterReturning: Running Method "+ joinPoint.getSignature().getName() + "===");
    }


    @Before(value = "execution(* com.soshiant.service.users.UserService.login(..))")
    public void logBeforeUsers(JoinPoint joinPoint) {

        logger.info(" LoggingAspect,UsersService, @Before: Before Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @After(value = "execution(* com.soshiant.service.users.UserService.login(..))")
    public void logAfterUsers(JoinPoint joinPoint) {

        logger.info(" LoggingAspect,UsersService, @After: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @Around("execution(* com.soshiant.service.users.*.*(..))")
    public void logAroundUsers(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,UsersService, @Around: Before Running Method "+ joinPoint.getSignature().getName() + "===");
        joinPoint.proceed();
        logger.info(" LoggingAspect,UsersService, @Around: After Running Method "+ joinPoint.getSignature().getName() + "===");
    }

    @AfterReturning("execution(* com.soshiant.service.users.*.*(..))")
    public void logAfterReturningUsers(JoinPoint joinPoint) throws Throwable{

        logger.info(" LoggingAspect,UsersService, @AfterReturning: Running Method "+ joinPoint.getSignature().getName() + "===");
    }


}
