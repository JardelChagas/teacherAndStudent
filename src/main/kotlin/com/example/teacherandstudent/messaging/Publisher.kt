package com.example.teacherandstudent.messaging

import com.example.teacherandstudent.domain.WorkStudent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class Publisher(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    suspend fun publishMessageTestCreate(id:String, solution:String, endIn:String){
        val newMessage = "$id;$solution;$endIn"
        kafkaTemplate.send("test-create",newMessage)

    }
    suspend fun SendAnswer(answer: WorkStudent, id_student: String){
        val newMenssage = id_student+";${answer.id};${answer.solution};${answer.endsIn}"
        kafkaTemplate.send("submit-solution",newMenssage)
    }
    suspend fun solver(id:String){
        kafkaTemplate.send("corretion", id)
    }

}