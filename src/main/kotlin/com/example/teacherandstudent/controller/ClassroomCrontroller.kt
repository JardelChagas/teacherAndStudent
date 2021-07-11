package com.example.teacherandstudent.controller

import com.example.teacherandstudent.domain.Classroom
import com.example.teacherandstudent.repository.ClassroomRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/classroom")
class ClassroomCrontroller(val repository: ClassroomRepository) {

    @PostMapping("/create")
    suspend fun createClassroom(@RequestBody c: Classroom): Classroom {
        return repository.save(c)
    }
}