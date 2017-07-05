package com.company.entity

import com.company.service.CustomUserDetailsService
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@Entity
open class Member:CustomUserDetailsService.UserRepositoryUserDetails{

    override fun getUsername(): String? {
        return name
    }

    override fun getPassword(): String? {
        return password
    }

    constructor()

    constructor(member: Member) {
        this.name = member.name
        this.password = member.password
    }

    lateinit var name: String


    private var password:String ?=null

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0


}

