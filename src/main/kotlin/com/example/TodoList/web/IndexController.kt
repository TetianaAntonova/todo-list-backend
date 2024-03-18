package com.example.TodoList.web

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/index")
@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
class IndexController {

    @GetMapping
    fun index(): String {
        println("In index")
        return "Hello!"
    }
}
