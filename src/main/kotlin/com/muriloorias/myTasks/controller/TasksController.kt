package com.muriloorias.myTasks.controller

import com.muriloorias.myTasks.model.Task
import com.muriloorias.myTasks.repository.TasksRepository
import com.muriloorias.myTasks.dto.DeleteTaskDTO
import com.muriloorias.myTasks.dto.EditTaskDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TasksController(private val repository : TasksRepository) {

    @GetMapping
    fun getAll(): List<Task>{
        return repository.findAll()
    }
    @PostMapping
    fun saveTask(@RequestBody task: Task): Task{
        return repository.save(task)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (DeleteTaskDTO(repository).deleteById(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
    @PutMapping("/edit/{id}")
    fun updateTask(
        @PathVariable id: Long,
        @RequestBody updatedTask: Task
    ): ResponseEntity<Task> {
        return try {
            val task = EditTaskDTO(repository).updateTask(id, updatedTask)
            ResponseEntity.ok(task)
        } catch (e: IllegalArgumentException) {
            ResponseEntity.notFound().build()
        }
    }

}