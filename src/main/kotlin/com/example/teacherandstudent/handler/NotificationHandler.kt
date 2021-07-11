package com.example.teacherandstudent.handler

import com.example.teacherandstudent.domain.Student
import com.example.teacherandstudent.repository.StudentRepository
import java.util.*

class NotificationHandler() {

    suspend fun workCreate(repositoryStudent:StudentRepository, classroom: String){
        var students: MutableList<Student> = repositoryStudent.findByClassroom(classroom)

        for (student in students){
            val notification: MutableList<String>? = student.notification
            notification?.add("trabalho 2 criado")
            student.notification = notification
            repositoryStudent.save(student)
            println(student.name)
        }
    }
    suspend fun submittedAnswer(repository: StudentRepository, id: String) {
        if(repository.findById(id) != null){
            var student: Student? = repository.findById(id)
            val notification: MutableList<String>? = student?.notification
            notification?.add("Sua resposta foi submetida com sucesso! ${Date().time}")
            repository.save(student!!)
        }

    }
}