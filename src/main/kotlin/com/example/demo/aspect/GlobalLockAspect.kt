package com.example.demo.aspect

import com.example.demo.annotation.GlobalLock
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
        try {
            val key = pjt.signature.name
            val method = pjt.target.javaClass.getMethod(key)
            val time = method.getAnnotation(GlobalLock::class.java).time

            if (lockMap.containsKey(key)) {
                throw RuntimeException()
            }

            lockMap[key] = UUID.randomUUID().toString() + time
            println("SET LOCK [$key] as [$time]")
            return pjt.proceed()
        } finally {
            val key = pjt.signature.toString()
            lockMap.remove(key)
            println("FREE LOCK [$key]")
        }
    }
}
