package com.example.demo.ratelimit

import java.util.concurrent.ConcurrentHashMap

object RateLimiter {
    val rateLimiter = ConcurrentHashMap<String, Long>()
}
