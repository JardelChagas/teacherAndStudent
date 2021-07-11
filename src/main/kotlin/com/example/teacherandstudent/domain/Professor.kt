package com.example.teacherandstudent.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Professor (
    @Id
    val key: String,
    val name: String,
    val classroom: String,
    val notification: MutableList<String> ?= null
)