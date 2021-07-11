package com.example.teacherandstudent.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Work(
    @Id
    val id              : String? = UUID.randomUUID().toString(),
    val professor       : String,
    val title           : String,
    val datePublication : String,
    val endsIn          : String,
    val descrition      : String,
    val solution        : String,
    val classroom       : String
)