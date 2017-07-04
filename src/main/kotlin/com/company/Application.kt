package com.company

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Application{
    /*@Bean
    open fun init(memberRepository: MemberRepository) = CommandLineRunner {
        memberRepository.save(Member("name","pwd"))
    }*/
}

fun main(args: Array<String>){
    SpringApplication.run(Application::class.java, *args);
}