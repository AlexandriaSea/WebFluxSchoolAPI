/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api.repository;

import com.example.wenjiezhou_comp303_assignment4_api.model.Enrollment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnrollmentRepository extends ReactiveMongoRepository<Enrollment, String> {
    Flux<Enrollment> findByStudentId(String studentId);

    Mono<Enrollment> findByStudentIdAndCourseId(String studentId, String courseId);
}
