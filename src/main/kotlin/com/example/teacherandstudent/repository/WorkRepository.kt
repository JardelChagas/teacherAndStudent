package com.example.teacherandstudent.repository

import com.example.teacherandstudent.domain.Work
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkRepository : CoroutineCrudRepository<Work, String> {
    suspend fun findByTitle(t:String): Work?
}