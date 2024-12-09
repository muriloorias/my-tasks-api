package com.muriloorias.myTasks.repository

import com.muriloorias.myTasks.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TasksRepository : JpaRepository<Task, Long> {
}