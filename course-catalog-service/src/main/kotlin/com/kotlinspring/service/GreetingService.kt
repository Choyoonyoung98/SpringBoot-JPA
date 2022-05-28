package com.kotlinspring.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class GreetingService {

    @Value("\${message}")
    lateinit var message: String //swift의 lazy와 같은 역할?
    fun retrieveGreeting(name: String) = "$name, $message"

}