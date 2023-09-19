package com.example.demo.lock

import java.util.concurrent.ConcurrentHashMap

object Lock {
    val lockMap: MutableMap<String, String> = ConcurrentHashMap()
}
