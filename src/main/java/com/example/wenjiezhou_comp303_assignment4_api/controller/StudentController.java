package com.example.wenjiezhou_comp303_assignment4_api.controller;

import com.example.wenjiezhou_comp303_assignment4_api.model.Student;
import com.example.wenjiezhou_comp303_assignment4_api.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/students")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Flux<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Mono<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Mono<Student> updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }
}
