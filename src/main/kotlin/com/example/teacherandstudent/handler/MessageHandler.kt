package com.example.teacherandstudent.handler

import com.example.teacherandstudent.domain.WorkStudent
import com.example.teacherandstudent.messaging.Publisher
import org.springframework.stereotype.Component

@Component
class MessageHandler(
    private val publisher : Publisher
) {
    suspend fun publishCreate(id:String, solutionr:String, endIn:String): String {
        publisher.publishMessageTestCreate(id, solutionr,endIn)
        return id
    }
    suspend fun sendAnswer(answer: WorkStudent, id_student: String){
        publisher.SendAnswer(answer,id_student)
    }
    suspend fun solver(id : String){
        publisher.solver(id)
    }
}