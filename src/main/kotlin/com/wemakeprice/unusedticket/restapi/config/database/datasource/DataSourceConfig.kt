package com.wemakeprice.unusedticket.restapi.config.database.datasource

import com.wemakeprice.unusedticket.restapi.config.database.properties.DataSourceProperties
import org.springframework.jdbc.datasource.DriverManagerDataSource

import javax.sql.DataSource

open class DataSourceConfig {

    protected fun <T : DataSourceProperties> createDatasource(properties: T): DataSource {
        var dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(properties.driverClassName)
        dataSource.url = properties.url
        dataSource.username = properties.username
        dataSource.password = properties.password
        return dataSource
    }
}
