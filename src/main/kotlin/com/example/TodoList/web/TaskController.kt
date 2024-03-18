package com.example.TodoList.web

import com.example.TodoList.domain.Task
import com.example.TodoList.domain.usecases.AddTaskUseCase
import com.example.TodoList.domain.usecases.GetTaskByIdUseCase
import com.example.TodoList.domain.usecases.GetTasksUseCase
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
class TaskController(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
    private val getTaskByIdUseCase: GetTaskByIdUseCase
) {

    companion object {
        private const val TASK_PATH = "/api/task"
        private const val GET_TASK_PATH = "/api/task/{id}"
    }

    @PostMapping(TASK_PATH)
    fun addTask(@RequestBody request: AddTaskRequest) {
        addTaskUseCase.add(request)
    }

    @GetMapping(TASK_PATH)
    fun getTasks(): List<Task> {
        println("get tasks")
        return getTasksUseCase.get()
    }

    @GetMapping(GET_TASK_PATH)
    fun getTasks(@PathVariable id: Long): Task? {
        println("get task: $id")
        return getTaskByIdUseCase.get(id)
    }
}

data class AddTaskRequest(
    val taskTitle: String
)
