package com.demo.platform.annotation;

import com.demo.platform.utils.PlatformThreadUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 */
@Aspect
public class ThreadAspect {
    private static final String UI_THREAD =
            "execution(@RunOnMainThread * *(..))";
    private static final String BACK_THREAD =
            "execution(@RunOnBackGround * *(..))";

    @Pointcut(UI_THREAD)
    public void methodRunOnUIThread() {
    }

    @Pointcut(BACK_THREAD)
    public void methodRunOnBackGround() {
    }

    @Around("methodRunOnUIThread()")
    public void aroundJoinPointUI(final ProceedingJoinPoint joinPoint) {
        if (!Thread.currentThread().isInterrupted()) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            RunOnMainThread annotation = method.getAnnotation(RunOnMainThread.class);
            int delayMillis = annotation.value();
            PlatformThreadUtils.postMainThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        joinPoint.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }, delayMillis);
        }
    }

    @Around("methodRunOnBackGround()")
    public void aroundJoinPointBack(final ProceedingJoinPoint joinPoint) {
        if (!Thread.currentThread().isInterrupted()) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            RunOnBackGround annotation = method.getAnnotation(RunOnBackGround.class);
            int delayMillis = annotation.value();
            PlatformThreadUtils.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        joinPoint.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            });
        }
    }
}
