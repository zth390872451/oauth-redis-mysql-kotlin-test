package com.company.controller

import com.company.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@RestController
class MemberController @Autowired constructor(val  memberRepository: MemberRepository){
    @GetMapping("/")
    fun findAll() = memberRepository.findAll()

    @GetMapping("/{userName}")
    fun findByUserName(@PathVariable userName:String) = memberRepository.findOneByName(userName)
}