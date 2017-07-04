package com.company.conf

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import redis.clients.jedis.JedisPoolConfig

/**
 * Created by Administrator on 2017/5/13 0013.
 */
@Configuration
open class RedisConfig {

    @Value("\${spring.redis.host}")
    private val host: String? = null
    @Value("\${spring.redis.password}")
    private val password: String? = null
    @Value("\${spring.redis.port}")
    private val port: Int = 0
    @Value("\${spring.redis.database}")
    private val database: Int = 0

    @Value("\${spring.redis.pool.max-active}")
    private val poolMaxActive: String? = null
    @Value("\${spring.redis.pool.max-wait}")
    private val poolMaxWait: String? = null
    @Value("\${spring.redis.pool.min-idle}")
    private val poolMinIdle: Int = 0
    @Value("\${spring.redis.pool.max-idle}")
    private val poolMaxIdle: Int = 0

    /**
     * @return Redis连接工厂Bean
     */
    @Bean
    open fun redisConnectionFactory(): RedisConnectionFactory {
        val jedisConnectionFactory = JedisConnectionFactory()
        jedisConnectionFactory.port = port
        jedisConnectionFactory.password = password
        jedisConnectionFactory.database = database
        jedisConnectionFactory.hostName = host
        val jedisPoolConfig = JedisPoolConfig()
        jedisPoolConfig.maxIdle = poolMaxIdle
        jedisPoolConfig.minIdle = poolMinIdle
        jedisConnectionFactory.poolConfig = jedisPoolConfig
        return jedisConnectionFactory
    }

}
