package com.example.teacherandstudent.controller

import com.example.teacherandstudent.domain.Work
import com.example.teacherandstudent.handler.MessageHandler
import com.example.teacherandstudent.handler.NotificationHandler
import com.example.teacherandstudent.repository.ProfessorRepository
import com.example.teacherandstudent.repository.StudentRepository
import com.example.teacherandstudent.repository.WorkRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/professor/work")
class WorkController(val repository: WorkRepository,
                     val repositoryStudent: StudentRepository,
                     val repositoryProfessor: ProfessorRepository,
                     private val messageHandler: MessageHandler) {

    @PostMapping("/create")
    suspend fun createWork(@RequestBody work:Work): Work {
        val notification  = NotificationHandler()
        notification.workCreate(repositoryStudent, work.classroom)
        messageHandler.publishCreate(work.id!!, work.solution, work.endsIn)
        return repository.save(work)
    }

    @GetMapping
    suspend fun works(): Flow<Work> {
        return repository.findAll()
    }
    @GetMapping("{id}/solve")
    suspend fun solver(@PathVariable id: String){
        messageHandler.solver(id)
    }


}