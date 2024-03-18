package com.example.TodoList.domain.usecases

import com.example.TodoList.domain.TaskService
import com.example.TodoList.web.AddTaskRequest
import org.springframework.stereotype.Service
import java.time.LocalDate

interface AddTaskUseCase {
    fun add(request: AddTaskRequest)
}

@Service
class AddTaskUseCaseImpl(
    private val taskService: TaskService
) : AddTaskUseCase {

    override fun add(request: AddTaskRequest) {
        taskService.save(request.taskTitle, LocalDate.now())
    }
}
