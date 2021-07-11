package com.example.teacherandstudent.repository

import com.example.teacherandstudent.domain.Professor
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorRepository: CoroutineCrudRepository<Professor, String> {
    suspend fun findByKey(key:String):Professor?
}