package com.example.wenjiezhou_comp303_assignment4_api.repository;

import com.example.wenjiezhou_comp303_assignment4_api.model.Enrollment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface EnrollmentRepository extends ReactiveMongoRepository<Enrollment, String> {
    Flux<Enrollment> findByStudentId(String studentId);
}
