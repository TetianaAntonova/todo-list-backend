package com.example.TodoList.storage

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "tasks")
class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "task_title")
    var taskTitle: String,

    @Column(name = "done")
    var done: Boolean,

    @Column(name = "created_at")
    var createdAt: LocalDate
)
