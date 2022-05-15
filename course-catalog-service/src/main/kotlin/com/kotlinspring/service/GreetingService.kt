package com.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class GreetingService {
    fun retrieveGreeting(name: String) = "Hello $name"

}