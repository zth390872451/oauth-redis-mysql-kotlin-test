package com.company.domain

import org.springframework.security.core.GrantedAuthority
import java.util.*

//默认角色
class Role : GrantedAuthority {

    var roles: Set<Role> = HashSet()

    override fun getAuthority(): String {
        return "USER"
    }

    companion object {

        private val serialVersionUID = -2633659220734280260L
    }


}
