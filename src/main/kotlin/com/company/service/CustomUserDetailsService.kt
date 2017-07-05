package com.company.service

import com.company.domain.Role
import com.company.repository.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
open class CustomUserDetailsService : UserDetailsService {

    override fun loadUserByUsername(userName: String?): UserDetails {
        var  member = memberRepository?.findOneByName(userName!!)
        //若是member为null，则强行转换的时候，userDetail =null
        val userDetail: UserDetails ?= member as? UserDetails
        //若是userDetail =null，则将抛出NPE
        return userDetail!!
    }

    private val log = LoggerFactory.getLogger(CustomUserDetailsService::class.java)

    @Autowired
    lateinit  var memberRepository: MemberRepository

    abstract class UserRepositoryUserDetails:UserDetails {

        override fun getAuthorities(): Collection<GrantedAuthority> {
            val role = Role()
            return role.roles
        }

        override fun isAccountNonExpired(): Boolean {
            return true
        }

        override fun isAccountNonLocked(): Boolean {
            return true
        }

        override fun isCredentialsNonExpired(): Boolean {
            return true
        }

        override fun isEnabled(): Boolean {
            return true
        }

        companion object {
            private val serialVersionUID = 1L
        }

    }
}