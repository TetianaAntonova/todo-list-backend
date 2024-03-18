package com.example.TodoList.domain.usecases

import com.example.TodoList.domain.Task
import com.example.TodoList.domain.TaskService
import org.springframework.stereotype.Service

interface GetTasksUseCase {
    fun get(): List<Task>
}

@Service
class GetTasksUseCaseImpl(
    private val taskService: TaskService
) : GetTasksUseCase {

    override fun get(): List<Task> {
        return taskService.getAll()
    }
}
