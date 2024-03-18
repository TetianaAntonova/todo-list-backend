package com.example.TodoList.domain.usecases

import com.example.TodoList.domain.Task
import com.example.TodoList.domain.TaskService
import org.springframework.stereotype.Service

interface GetTaskByIdUseCase {
    fun get(id: Long): Task?
}

@Service
class GetTaskByIdUseCaseImpl(
    private val taskService: TaskService
) : GetTaskByIdUseCase {

    override fun get(id: Long): Task? {
        return taskService.getById(id)
    }
}
