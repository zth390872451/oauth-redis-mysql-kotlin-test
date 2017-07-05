package com.company.repository

import com.company.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Administrator on 2017/7/4 0004.
 */
interface MemberRepository : JpaRepository<Member, Long>{

    fun findOneByName(name:String):Member

}
