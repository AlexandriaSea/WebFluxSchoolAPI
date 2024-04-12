package com.example.wenjiezhou_comp303_assignment4_api.service;

import com.example.wenjiezhou_comp303_assignment4_api.model.Enrollment;
import com.example.wenjiezhou_comp303_assignment4_api.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
}
