package com.example.demo.controller

import com.example.demo.annotation.GlobalLock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GlobalLock
    @GetMapping
    fun getFinish(): Any? {
        return "FINISH"
    }

    @GlobalLock
    @GetMapping("/demo")
    fun getDemo(): Any? {
        return "DEMO"
    }
}