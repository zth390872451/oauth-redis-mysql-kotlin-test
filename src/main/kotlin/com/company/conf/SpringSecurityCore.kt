package com.company.conf

import com.company.service.CustomUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by Administrator on 2017/7/5 0005.
 */

@Configuration
open  class SpringSecurityCore(@Autowired
private var customUserDetailsService: CustomUserDetailsService) : WebSecurityConfigurerAdapter() {

    /*@Autowired
    lateinit var  redisTemplate: RedisTemplate<String, String> ;*/
/*
    @Bean
    open fun  cacheManager():CacheManager{
        val cacheManager = RedisCacheManager(redisTemplate);
        return cacheManager;
    }

    @Bean
    open fun  redisCache(): RedisCache{
        val tt = ByteArray(1)
        val redisCache = RedisCache("redisCache", tt, redisTemplate, 100000);
        return redisCache;
    }*/
/*
    private fun charToByte(c: Char): Byte {
        return "0123456789ABCDEF".indexOf(c).toByte()
    }*/
/*

    @Bean
    @Throws(Exception::class)
    open fun   userCache():UserCache{
        var userCache = SpringCacheBasedUserCache(redisCache());
        return userCache;
    }
*/


    @Throws(Exception::class)
    override
    fun configure(auth: AuthenticationManagerBuilder){
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * 用户认证相关配置 UserDetails
     */
    @Bean
    @Throws(Exception::class)
    open fun daoAuthenticationProvider(): AuthenticationProvider{
        val authenticationProvider = DaoAuthenticationProvider();
//        authenticationProvider.setUserCache(userCache());
        //自定义用户认证检查
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        return authenticationProvider;
    }

    override
    @Throws(Exception::class)
    fun configure(http: HttpSecurity){
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll();//允许所有请求
    }
}
