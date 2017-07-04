package com.company.service

import com.company.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@Service
open class CustomUserDetailsService : UserDetailsService {
    override fun loadUserByUsername(userName: String?): UserDetails {
        var  member = memberRepository?.findOneByName(userName!!)
        return UserRepositoryUserDetails(member!!);
    }

    private val log = LoggerFactory.getLogger(CustomUserDetailsService::class.java)

    @Autowired
    private val memberRepository: MemberRepository ?=null


}