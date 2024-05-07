package code.task21;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionLogger {
    private final Logger logger = LoggerFactory.getLogger(ExecutionLogger.class);

    @Pointcut("execution(* code.task21.ShopService.*(..))")
    public void serviceMethodsPointcut() {}

    @Around("serviceMethodsPointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        logger.info("Method {} done in \033[31m{} ms\033[0m", joinPoint.getSignature().getName(), executionTime);

        return result;
    }
}
