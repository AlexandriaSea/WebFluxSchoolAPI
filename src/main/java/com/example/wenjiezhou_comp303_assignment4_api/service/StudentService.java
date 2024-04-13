/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api.service;

import com.example.wenjiezhou_comp303_assignment4_api.model.Student;
import com.example.wenjiezhou_comp303_assignment4_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service layer for managing students within the application. This class handles all business logic
 * pertaining to students and interacts with the database through repositories. It makes use of Spring's
 * reactive programming model to handle asynchronous and non-blocking operations, which enhances performance
 * and scalability, especially useful in I/O-bound environments.
 */

@Service
@Transactional
@AllArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> updateStudent(String id, Student updatedStudent) {
        return studentRepository.findById(id)
                .flatMap(student -> {
                    updatedStudent.set_id(id);
                    return studentRepository.save(updatedStudent);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteStudent(String id) {
        return studentRepository.findById(id)
                .flatMap(student -> studentRepository.delete(student)
                );
    }

    public Mono<Student> getStudentByEmailAndPassword(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password)
                .switchIfEmpty(Mono.empty());
    }
}
