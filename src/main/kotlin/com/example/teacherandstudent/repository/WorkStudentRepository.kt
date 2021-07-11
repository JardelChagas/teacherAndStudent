package com.example.teacherandstudent.repository

import com.example.teacherandstudent.domain.Work
import com.example.teacherandstudent.domain.WorkStudent
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkStudentRepository: CoroutineCrudRepository<Work, String> {
    suspend fun findByTitle(t:String): WorkStudent?
}