package com.wemakeprice.unusedticket.restapi.aspect.pointcut

import org.aspectj.lang.annotation.Pointcut

class RestPointcut {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    fun get() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    fun post() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    fun put() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    fun delete() {
    }
}
