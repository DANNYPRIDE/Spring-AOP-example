package com.example.demo.aspect

import com.example.demo.annotation.RateLimit
import com.example.demo.ratelimit.RateLimiter.rateLimiter
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

@Aspect
@Component
class RateLimitAspect {
    @Around("@annotation(com.example.demo.annotation.RateLimit)")
    fun rateLimit(pjt: ProceedingJoinPoint): Any? {
        val key = pjt.signature.name
        val method = pjt.target.javaClass.getMethod(key)
        val limit = method.getAnnotation(RateLimit::class.java).limit
        try {
            rateLimiter.compute(key) { k, v ->
                if (v == null) {
                    1
                } else if (v >= limit) {
                    throw RuntimeException()
                } else {
                    v + 1
                }
            }
            return pjt.proceed()
        } finally {
        }
    }
}
