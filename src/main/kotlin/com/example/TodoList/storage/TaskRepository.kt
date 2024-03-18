package com.example.TodoList.storage

import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<TaskEntity, Long> {
    fun findAllByOrderByCreatedAt(): List<TaskEntity>
}
