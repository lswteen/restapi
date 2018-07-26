package com.wemakeprice.unusedticket.restapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [ErrorMvcAutoConfiguration::class])
class RestapiApplication

fun main(args: Array<String>) {
    runApplication<RestapiApplication>(*args)
}
