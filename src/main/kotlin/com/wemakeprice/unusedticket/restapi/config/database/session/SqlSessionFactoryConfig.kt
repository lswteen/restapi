package com.wemakeprice.unusedticket.restapi.config.database.session


import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver

import javax.sql.DataSource

@Configuration
class SqlSessionFactoryConfig {

    val mybatisMapperResourcePath = "classpath:mapper/**/*.xml"

    @Bean(name = ["masterSqlSessionFactory"])
    @Primary
    @Throws(Exception::class)
    fun masterSqlSessionFactory(@Qualifier("masterDataSource") masterDataSource: DataSource): SqlSessionFactory? {
        return this.createSqlSessionFactory(masterDataSource)
    }

    @Bean(name = ["slaveSqlSessionFactory"])
    @Throws(Exception::class)
    fun slaveSqlSessionFactory(@Qualifier("slaveDataSource") slaveDataSource: DataSource): SqlSessionFactory? {
        return this.createSqlSessionFactory(slaveDataSource)
    }

    @Throws(Exception::class)
    private fun createSqlSessionFactory(dataSource: DataSource): SqlSessionFactory? {
        var sqlSessionFactory = SqlSessionFactoryBean()
        sqlSessionFactory.setDataSource(dataSource)

        var resolver = PathMatchingResourcePatternResolver()
        sqlSessionFactory.setMapperLocations(resolver.getResources(mybatisMapperResourcePath))

        return sqlSessionFactory.`object`
    }
}
