package com.example.TodoList.domain.usecases

import com.example.TodoList.domain.Task
import com.example.TodoList.domain.TaskService
import org.springframework.stereotype.Service

interface UpdateTaskUseCase {
    fun updateDone(id: Long, done: Boolean): Task?
}

@Service
class UpdateTaskUseCaseImpl(
    private val taskService: TaskService
) : UpdateTaskUseCase {
    override fun updateDone(id: Long, done: Boolean): Task? {
        return taskService.updateDone(id, done)
    }
}
