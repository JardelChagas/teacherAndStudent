package com.example.teacherandstudent.domain
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Answer(
    val answer : String
)