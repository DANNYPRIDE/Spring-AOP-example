package com.example.demo.aspect

import com.example.demo.lock.Lock.lockMap
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

import org.springframework.stereotype.Component
import java.lang.reflect.*
import java.util.UUID

@Aspect
@Component
class GlobalLockAspect {
    @Around("@annotation(com.example.demo.annotation.GlobalLock)")
    fun setLock(pjt: ProceedingJoinPoint): Any? {
        val key = pjt.signature.name
        val method = pjt.target.javaClass.getMethod(key)
        try {
            if (lockMap.containsKey(key)) {
                throw RuntimeException()
            }
            lockMap[key] = UUID.randomUUID().toString()
            println("SET LOCK [$key]")
            return pjt.proceed()
        } finally {
            lockMap.remove(key)
            println("FREE LOCK [$key]")
        }
    }
}
