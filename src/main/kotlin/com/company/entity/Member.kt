package com.company.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@Entity
open class Member{
    constructor()
    constructor(name: String, password: String) {
        this.name = name
        this.pwd = password
    }

    constructor(member: Member) {
        this.name = member.name
        this.pwd = member.pwd
    }
    var name: String =""
    var pwd:String=""
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long =0


}

