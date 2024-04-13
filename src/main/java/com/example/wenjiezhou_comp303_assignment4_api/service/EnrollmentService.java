/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api.service;

import com.example.wenjiezhou_comp303_assignment4_api.model.Enrollment;
import com.example.wenjiezhou_comp303_assignment4_api.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service layer for managing enrollments within the application. This class handles all business logic
 * pertaining to enrollments and interacts with the database through repositories. It makes use of Spring's
 * reactive programming model to handle asynchronous and non-blocking operations, which enhances performance
 * and scalability, especially useful in I/O-bound environments.
 */

@Service
@Transactional
@AllArgsConstructor
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Flux<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Mono<Enrollment> getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }

    public Mono<Enrollment> addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Mono<Enrollment> updateEnrollment(String id, Enrollment updatedEnrollment) {
        return enrollmentRepository.findById(id)
                .flatMap(enrollment -> {
                    updatedEnrollment.set_id(id);
                    return enrollmentRepository.save(updatedEnrollment);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteEnrollment(String id) {
        return enrollmentRepository.findById(id)
                .flatMap(enrollment -> enrollmentRepository.delete(enrollment));
    }

    public Mono<Void> deleteEnrollmentByStudentIdAndCourseId(String studentId, String courseId) {
        return enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId)
                .flatMap(enrollment -> enrollmentRepository.delete(enrollment));
    }
}
