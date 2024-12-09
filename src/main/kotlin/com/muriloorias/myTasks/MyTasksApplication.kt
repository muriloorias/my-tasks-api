package com.muriloorias.myTasks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyTasksApplication

fun main(args: Array<String>) {
	runApplication<MyTasksApplication>(*args)
}