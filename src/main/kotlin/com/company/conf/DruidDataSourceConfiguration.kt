package com.company.conf

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException

@Configuration
open class DruidDataSourceConfiguration{

    @Value("\${spring.datasource.dataSourceClassName}")
    val driverClass :String? = null

    @Value("\${spring.datasource.url}")
    val jdbcUrl: String? = null

    @Value("\${spring.datasource.username}")
    val username: String? = null

    @Value("\${spring.datasource.password}")
    val password: String? = null

    @Value("\${spring.datasource.initialSize}")
    val initialSize: Int = 0// 初始化时建立物理连接的个数

    @Value("\${spring.datasource.maxActive}")
    val maxActive: Int = 0  // 最大连接池数量

    @Value("\${spring.datasource.minIdle}")
    val minIdle: Int = 0    // 最小连接池数量

    @Value("\${spring.datasource.maxWait}")
    val maxWait: Long = 0    // 获取连接时最大等待时间，单位毫秒

    @Value("\${spring.datasource.validationQuery}")
    val validationQuery: String? = null //用来检测连接是否有效的sql，要求是一个查询语句。

    @Value("\${spring.datasource.testOnBorrow}")
    val testOnBorrow: Boolean = false
    @Value("\${spring.datasource.testOnReturn}")

    val testOnReturn: Boolean = false
    @Value("\${spring.datasource.testWhileIdle}")

    val testWhileIdle: Boolean = false
    @Value("\${spring.datasource.timeBetweenEvictionRunsMillis}")

    val timeBetweenEvictionRunsMillis: Long = 0
    @Value("\${spring.datasource.minEvictableIdleTimeMillis}")

    val minEvictableIdleTimeMillis: Long = 0

    @Value("\${spring.datasource.removeAbandoned}")
    val removeAbandoned: Boolean = false

    @Value("\${spring.datasource.removeAbandonedTimeout}")
    val removeAbandonedTimeout: Int = 0

    @Value("\${spring.datasource.logAbandoned}")
    val logAbandoned: Boolean = false

    @Value("\${spring.datasource.filters}")
    val filters: String? = null

    @Value("\${spring.datasource.poolPreparedStatements}")
    val poolPreparedStatements: Boolean = false

    @Value("\${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    val maxPoolPreparedStatementPerConnectionSize: Int = 0

    @Bean
    open fun DruidDataSource(): DruidDataSource {
        val druidDataSource = com.alibaba.druid.pool.DruidDataSource()
        druidDataSource.driverClassName = driverClass
        druidDataSource.url = jdbcUrl
        druidDataSource.username = username
        druidDataSource.password = password

        druidDataSource.initialSize = initialSize
        druidDataSource.maxActive = maxActive
        druidDataSource.minIdle = minIdle
        druidDataSource.maxWait = maxWait

        druidDataSource.validationQuery = validationQuery
        druidDataSource.isTestOnBorrow = testOnBorrow
        druidDataSource.isTestOnReturn = testOnReturn
        druidDataSource.isTestWhileIdle = testWhileIdle
        druidDataSource.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis
        druidDataSource.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis

        druidDataSource.isRemoveAbandoned = removeAbandoned
        druidDataSource.removeAbandonedTimeout = removeAbandonedTimeout
        druidDataSource.isLogAbandoned = logAbandoned

        druidDataSource.isPoolPreparedStatements = poolPreparedStatements
        druidDataSource.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize

        try {
            druidDataSource.setFilters(filters)
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return druidDataSource
    }
}