package com.h21cloud.common.aspect;

import com.h21cloud.common.core.model.vo.wrapper.Wrapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 操作日志切面类
 *
 * @author shaofeng
 */
@Component
@Aspect
public class LogAspect {

    private ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    /**
     * 切点.
     */
    @Pointcut("@annotation(com.h21cloud.common.anno.Logging)")
    public void logging() {
    }

    /**
     * Do before 前置通知.
     */
    @Before("logging()")
    public void doBefore() {
        this.threadLocal.set(new Date(System.currentTimeMillis()));
    }

    /**
     * Do after 后置通知.
     *
     * @param joinPoint   the join point
     * @param returnValue the return value
     */
    @AfterReturning(pointcut = "logging()", returning = "returnValue")
    public void doAfter(final JoinPoint joinPoint, final Object returnValue) {
        if (returnValue instanceof Wrapper) {
            Wrapper result = (Wrapper) returnValue;
        }
    }

    /**
     * log deal
     *
     * @param point   the join point
     * @param wrapper return val
     */
    private void handleLog(JoinPoint point, Wrapper wrapper) {
        final Date startTime = this.threadLocal.get();
        final Date endTime = new Date(System.currentTimeMillis());
    }
}
