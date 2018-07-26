package com.wemakeprice.unusedticket.restapi.config.database.session

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class SqlSessionTemplateConfig {

    @Bean(name = ["masterSqlSessionTemplate"])
    @Primary
    fun masterSessionTemplate(@Qualifier("masterSqlSessionFactory") masterSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return this.createSessionTemplate(masterSessionFactory)
    }

    @Bean(name = ["slaveSqlSessionTemplate"])
    fun slaveSessionTemplate(@Qualifier("slaveSqlSessionFactory") slaveSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return this.createSessionTemplate(slaveSessionFactory)
    }

    private fun createSessionTemplate(sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}
