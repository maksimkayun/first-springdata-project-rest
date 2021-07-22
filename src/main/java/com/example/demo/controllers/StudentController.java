package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final StudentRepository repository;

    StudentController(StudentRepository repository) {
        this.repository = repository;
    }  
    
    @GetMapping("/students")
    Iterable<Student> all() {
        return repository.findAll();
    } 
    
    @PostMapping("/students")
    Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }  

    @GetMapping("/students/{id}")
    Student one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
