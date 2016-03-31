package pl.edu.agh.ztis.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by Jakub Sloniec on 10.03.2016.
 */

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(* pl.edu.agh.ztis.controller..*.*(..))")
	public void restControlPointcut() {
	}

	@Pointcut("execution(* pl.edu.agh.ztis.service..*.*(..))")
	public void sevicePointcut() {
	}

	@Pointcut("restControlPointcut() || sevicePointcut()")
	public void combinedPointcut() {
	}

	@Around("combinedPointcut()")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
		Object retVal;

		try {
			StringBuffer startMessageStringBuffer = new StringBuffer();

			startMessageStringBuffer.append("Start method ");
			startMessageStringBuffer.append(joinPoint.getSignature().getName());
			startMessageStringBuffer.append("(");

			Object[] args = joinPoint.getArgs();
			for (Object arg : args) {
				startMessageStringBuffer.append(arg).append(",");
			}
			if (args.length > 0) {
				startMessageStringBuffer.deleteCharAt(startMessageStringBuffer.length() - 1);
			}

			startMessageStringBuffer.append(")");

			logger.info(startMessageStringBuffer.toString());

			StopWatch stopWatch = new StopWatch();
			stopWatch.start();

			retVal = joinPoint.proceed();

			stopWatch.stop();

			StringBuffer endMessageStringBuffer = new StringBuffer();
			endMessageStringBuffer.append("Finish method ");
			endMessageStringBuffer.append(joinPoint.getSignature().getName());
			endMessageStringBuffer.append("(..); execution time: ");
			endMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
			endMessageStringBuffer.append(" ms;");

			logger.info(endMessageStringBuffer.toString());
		} catch (Throwable ex) {
			StringBuffer errorMessageStringBuffer = new StringBuffer();

			// Create error message
			logger.error(errorMessageStringBuffer.toString(), ex);

			throw ex;
		}

		return retVal;
	}
}

