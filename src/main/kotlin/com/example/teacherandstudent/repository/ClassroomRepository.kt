package com.example.teacherandstudent.repository

import com.example.teacherandstudent.domain.Classroom
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassroomRepository: CoroutineCrudRepository<Classroom, String> {
    suspend fun findByName(name:String):Classroom?
}