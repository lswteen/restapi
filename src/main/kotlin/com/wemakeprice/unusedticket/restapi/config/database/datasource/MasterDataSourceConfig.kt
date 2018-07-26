package com.wemakeprice.unusedticket.restapi.config.database.datasource

import com.wemakeprice.unusedticket.restapi.config.database.mapper.MasterMapper
import com.wemakeprice.unusedticket.restapi.config.database.properties.MasterDataSourceProperties
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.sql.DataSource

@Configuration
@MapperScan(basePackages = ["com.wemakeprice.unusedticket.restapi"], annotationClass = MasterMapper::class, sqlSessionFactoryRef = "masterSqlSessionFactory")
@EnableTransactionManagement
class MasterDataSourceConfig : DataSourceConfig() {

    @Autowired
    lateinit var masterDatasourceProperties: MasterDataSourceProperties

    @Bean(name = ["masterDataSource"])
    @Primary
    fun masterDataSource(): DataSource {
        return createDatasource(masterDatasourceProperties)
    }
}