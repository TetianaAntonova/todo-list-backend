package com.example.TodoList

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestTodoListApplication

fun main(args: Array<String>) {
	fromApplication<TodoListApplication>().with(TestTodoListApplication::class).run(*args)
}
