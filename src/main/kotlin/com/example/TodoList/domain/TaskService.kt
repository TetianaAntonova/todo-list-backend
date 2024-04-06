package com.example.TodoList.domain

import com.example.TodoList.storage.TaskEntity
import com.example.TodoList.storage.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate

interface TaskService {
    fun save(taskTitle: String, createdAt: LocalDate)
    fun getAll(): List<Task>
    fun getById(id: Long): Task?
    fun updateDone(id: Long, done: Boolean): Task?
}

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository
) : TaskService {

    override fun save(taskTitle: String, createdAt: LocalDate) {
        taskRepository.save(TaskEntity(taskTitle = taskTitle, done = false, createdAt = createdAt))
    }

    override fun getAll(): List<Task> {
        return taskRepository.findAllByOrderByCreatedAt().map { it.toTask() }
    }

    override fun getById(id: Long): Task? {
        return taskRepository.findByIdOrNull(id)?.toTask()
    }

    override fun updateDone(id: Long, done: Boolean): Task? {
        return taskRepository.findByIdOrNull(id)?.let {
            it.done = done
            taskRepository.save(it)
        }?.toTask()
    }

    private fun TaskEntity.toTask(): Task {
        return Task(id!!, taskTitle, done, createdAt)
    }
}
