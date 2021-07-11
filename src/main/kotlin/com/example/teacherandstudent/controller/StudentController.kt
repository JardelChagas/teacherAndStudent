package com.example.teacherandstudent.controller

import com.example.teacherandstudent.domain.Student
import com.example.teacherandstudent.domain.WorkStudent
import com.example.teacherandstudent.handler.MessageHandler
import com.example.teacherandstudent.handler.NotificationHandler
import com.example.teacherandstudent.repository.StudentRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(val repository: StudentRepository, private val messageHandler: MessageHandler) {
    @GetMapping("/{id}")
    suspend fun hiStudent(@PathVariable id:String): String{
        val studentName : String? = repository.findByKey(id)?.name
        return "Seja bem vindo(a), $studentName"
    }

    @GetMapping("/{id}/notification")
    suspend fun getNotification(@PathVariable id:String): MutableList<String>? {
        val studentNotifications : MutableList<String>? = repository.findByKey(id)?.notification
        return studentNotifications
    }

    @PostMapping("/create")
    suspend fun createStudent(@RequestBody student: Student): Student {
        return repository.save(student)
    }

    @PutMapping("/{id}/submitSolution")
    suspend fun submitSolution(@PathVariable id: String, @RequestBody answer: WorkStudent){
        messageHandler.sendAnswer(answer, id)
        val notification  = NotificationHandler()
        notification.submittedAnswer(repository, id)
        println(answer.solution)
    }
/*
    @PostMapping("iriri")
    suspend fun submitSolution(@PathVariable id:String, @RequestBody solution: String){
        println(solution)
    }


    @PostMapping("/message")
    suspend fun publish(@RequestBody message: String): String {
        return messageHandler.publish(message, "05/02/22","no id")
    }



*/
}