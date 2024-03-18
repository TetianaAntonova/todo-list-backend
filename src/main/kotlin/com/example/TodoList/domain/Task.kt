package com.example.TodoList.domain

import java.time.LocalDate

data class Task(
    val id: Long,
    val taskTitle: String,
    val done: Boolean,
    val createdAt: LocalDate
)
