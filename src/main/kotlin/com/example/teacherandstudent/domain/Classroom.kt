package com.example.teacherandstudent.domain
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Classroom (
    @Id
    val id: String,
    val name: String,
    var professors: MutableList<Professor>? = null,
    var students: MutableList<Student>? = null,
    var works: MutableList<Work>? = null
)