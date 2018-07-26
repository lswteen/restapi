package com.wemakeprice.unusedticket.restapi.config.database.datasource

import com.wemakeprice.unusedticket.restapi.config.database.mapper.SlaveMapper
import com.wemakeprice.unusedticket.restapi.config.database.properties.SlaveDataSourceProperties
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource

@Configuration
@MapperScan(basePackages = ["com.wemakeprice.unusedticket.restapi"], annotationClass = SlaveMapper::class, sqlSessionFactoryRef = "slaveSqlSessionFactory")
@EnableTransactionManagement
class SlaveDataSourceConfig : DataSourceConfig() {

    @Autowired
    lateinit var slaveDatasourceProperties: SlaveDataSourceProperties

    @Bean(name = ["slaveDataSource"])
    fun slaveDataSource(): DataSource {
        return createDatasource(slaveDatasourceProperties)
    }
}