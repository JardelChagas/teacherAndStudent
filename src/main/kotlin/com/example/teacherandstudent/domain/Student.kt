package com.example.teacherandstudent.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.management.AttributeChangeNotification

@Document
data class Student (
    @Id
    val key: String,
    val name: String,
    val classroom: String,
    var notification: MutableList<String> ?= null
)
