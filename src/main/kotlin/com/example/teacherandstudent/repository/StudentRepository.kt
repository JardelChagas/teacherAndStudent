package com.example.teacherandstudent.repository

import com.example.teacherandstudent.domain.Student
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository: CoroutineCrudRepository<Student, String> {
    suspend fun findByKey(key:String): Student?
    suspend fun findByClassroom(cr:String):MutableList<Student>

}
