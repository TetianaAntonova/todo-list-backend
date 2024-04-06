package com.example.TodoList.web

import com.example.TodoList.domain.Task
import com.example.TodoList.domain.usecases.*
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:8080", "http://localhost:3000"])
class TaskController(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
    private val getTaskByIdUseCase: GetTaskByIdUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase
) {

    companion object {
        private const val TASKS_PATH = "/api/task"
        private const val TASK_PATH = "/api/task/{id}"
    }

    @PostMapping(TASKS_PATH)
    fun addTask(@RequestBody request: AddTaskRequest) {
        addTaskUseCase.add(request)
    }

    @PatchMapping(TASK_PATH)
    fun updateDone(@PathVariable id: Long, @RequestParam done: Boolean): Task? {
        println("IN update - $id, $done")
        return updateTaskUseCase.updateDone(id, done)
    }

    @GetMapping(TASKS_PATH)
    fun getTasks(): List<Task> {
        return getTasksUseCase.get()
    }

    @GetMapping(TASK_PATH)
    fun getTasks(@PathVariable id: Long): Task? {
        println("get task: $id")
        return getTaskByIdUseCase.get(id)
    }
}

data class AddTaskRequest(
    val taskTitle: String
)
