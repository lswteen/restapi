package com.wemakeprice.unusedticket.restapi.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingController {

    @Before("com.wemakeprice.unusedticket.restapi.aspect.pointcut.RestPointcut.get()")
    fun beforeGetMapping(joinPoint: JoinPoint) {
        logger.info("==================== REST API CALL ====================")
        logger.info("Executing GET Type method : " + joinPoint.signature.name)
    }

    @Before("com.wemakeprice.unusedticket.restapi.aspect.pointcut.RestPointcut.post()")
    fun beforePostMapping(joinPoint: JoinPoint) {
        logger.info("==================== REST API CALL ====================")
        logger.info("Executing POST Type method : " + joinPoint.signature.name)
    }

    @Before("com.wemakeprice.unusedticket.restapi.aspect.pointcut.RestPointcut.put()")
    fun beforePutMapping(joinPoint: JoinPoint) {
        logger.info("==================== REST API CALL ====================")
        logger.info("Executing PUT Type method : " + joinPoint.signature.name)
    }

    @Before("com.wemakeprice.unusedticket.restapi.aspect.pointcut.RestPointcut.delete()")
    fun beforeDeleteMapping(joinPoint: JoinPoint) {
        logger.info("==================== REST API CALL ====================")
        logger.info("Executing DELETE Type method : " + joinPoint.signature.name)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(LoggingController::class.java)
    }
}
