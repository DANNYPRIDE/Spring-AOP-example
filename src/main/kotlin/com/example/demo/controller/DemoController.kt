package com.example.demo.controller

import com.example.demo.annotation.GlobalLock
import com.example.demo.annotation.RateLimit
import com.example.demo.ratelimit.RateLimiter.rateLimiter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @GlobalLock
    @GetMapping
    fun getFinish(): Any? {
        return "FINISH"
    }

    @RateLimit(500)
    @GetMapping("/demo")
    fun getDemo(): Any? {
        return "DEMO"
    }

    @GetMapping("/in")
    fun get(): Any? {
        return rateLimiter.entries
    }
}
