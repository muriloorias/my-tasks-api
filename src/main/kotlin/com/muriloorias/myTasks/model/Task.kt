package com.muriloorias.myTasks.model

import jakarta.persistence.*

@Entity
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "text", nullable = false)
    var text: String,
    @Column(name = "urgency", nullable = false)
     var urgency: Boolean
)