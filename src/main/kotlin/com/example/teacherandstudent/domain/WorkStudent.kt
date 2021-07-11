package com.example.teacherandstudent.domain

import org.springframework.data.annotation.Id

data class WorkStudent (
    @Id
    val id      : String,
    val endsIn  : String,
    val note    : String ?="0",
    val solution: String,
)