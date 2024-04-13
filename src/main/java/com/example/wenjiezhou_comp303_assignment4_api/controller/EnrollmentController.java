/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api.controller;

import com.example.wenjiezhou_comp303_assignment4_api.model.Enrollment;
import com.example.wenjiezhou_comp303_assignment4_api.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST Controller for managing enrollments, providing CRUD operations and additional
 * functionalities through an enrollment service. This controller uses reactive programming
 * principles to handle asynchronous and non-blocking operations.
 */

@RequestMapping("api/enrollments")
@AllArgsConstructor
@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public Flux<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public Mono<Enrollment> getEnrollmentById(@PathVariable String id) {
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping
    public Mono<Enrollment> addEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.addEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    public Mono<Enrollment> updateEnrollment(@PathVariable String id, @RequestBody Enrollment updatedEnrollment) {
        return enrollmentService.updateEnrollment(id, updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEnrollment(@PathVariable String id) {
        return enrollmentService.deleteEnrollment(id);
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public Mono<Void> deleteEnrollmentByStudentIdAndCourseId(@PathVariable String studentId, @PathVariable String courseId) {
        return enrollmentService.deleteEnrollmentByStudentIdAndCourseId(studentId, courseId);
    }
}
