package com.company.service

import com.company.domain.Role
import com.company.entity.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Created by Administrator on 2017/7/5 0005.
 */
open class UserRepositoryUserDetails(member: Member) : Member(member) ,UserDetails {

    override fun getPassword(): String? {
        throw UnsupportedOperationException()
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        val role = Role()
        return role.roles
    }

    override fun getUsername(): String {
        return name
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