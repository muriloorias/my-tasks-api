package com.muriloorias.myTasks.dto

import com.muriloorias.myTasks.repository.TasksRepository
import org.springframework.stereotype.Service

@Service
class DeleteTaskDTO(private val repository: TasksRepository) {
    fun deleteById(id: Long): Boolean {
        if (repository.existsById(id)) {
            repository.deleteById(id)
            return true
        }
        return false
    }
}
