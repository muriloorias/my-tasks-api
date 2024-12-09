package com.muriloorias.myTasks.dto

import com.muriloorias.myTasks.model.Task
import com.muriloorias.myTasks.repository.TasksRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class EditTaskDTO(private val repository: TasksRepository) {
    @Transactional
    fun updateTask(id: Long, updatedTask: Task): Task{
        val task = repository.findById(id).orElseThrow{
           IllegalArgumentException("a tarefa $id não foi encontrada")
        }

        task.title = updatedTask.title
        task.text = updatedTask.text
        task.urgency = updatedTask.urgency

        return repository.save(task)
    }
}