package com.example.wenjiezhou_comp303_assignment4_api.repository;

import com.example.wenjiezhou_comp303_assignment4_api.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
}
