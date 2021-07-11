package com.example.teacherandstudent.controller

import com.example.teacherandstudent.domain.Professor
import com.example.teacherandstudent.repository.ProfessorRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/professor")
class ProfessorController(val repository: ProfessorRepository) {
    @PostMapping
    suspend fun createProfessor(@RequestBody p:Professor): Professor {
        return repository.save(p)
    }

    @GetMapping("/{name}")
    suspend fun hiProfessor(@PathVariable name:String): String{
        return "Seja bem vindo(a), $name!"

    }


   /** @PostMapping
    fun creatWork(){

    }
    @GetMapping("/notification")
    fun allNotification(){

    }**/
}