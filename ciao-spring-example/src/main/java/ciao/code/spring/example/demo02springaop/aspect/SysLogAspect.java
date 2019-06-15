package ciao.code.spring.example.demo02springaop.aspect;

import ciao.code.spring.example.demo02springaop.annotation.SysLog;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 操作日志使用spring event异步入库
 *
 * @author L.cm
 */
@Slf4j
@Aspect
@Component
public class SysLogAspect {
	@SneakyThrows
	@Around("@annotation(sysLog)")
	public Object around(ProceedingJoinPoint point, SysLog sysLog) {
		String strClassName = point.getTarget().getClass().getName();
		String strMethodName = point.getSignature().getName();
		Object[] args = point.getArgs();
		for (Object arg : args) {
			System.out.println(arg.toString());
		}

		Long startTime = System.currentTimeMillis();
		Object obj = point.proceed();
		Long endTime = System.currentTimeMillis();
		long result =endTime - startTime;
		log.info("[obj]:{},[类名]:{},[方法]:{},[运行时间]:{},[sysLog注解的value]:{}",
				obj,strClassName, strMethodName,result,sysLog.value());
		return obj;
	}

}
