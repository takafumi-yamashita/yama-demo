package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ログ出力共通クラス
 *
 */
@Aspect
@Component
public class CommonLogAspect {
	
	/** ロガー(Logback) */
	private final Logger log = LoggerFactory.getLogger(CommonLogAspect.class);
	
	@Around("execution(* com.example.demo..*(..))")
	public Object writeLog(ProceedingJoinPoint jp) throws Throwable{
		Object targetMethodReturn = null;
		//開始ログを出力
		log.info("start:" + jp.getSignature().toString());
		
		try {
			//JoinPointのメソッドを実行
			targetMethodReturn = jp.proceed();
		} catch (Throwable t) {
			//エラーログを出力
			log.error(t.toString());
			throw t;
		}
		
		//終了ログを出力
		log.info("end:" + jp.getSignature().toString());
		//これで次画面への遷移が行える(Controller)
		return targetMethodReturn;
	}

}
