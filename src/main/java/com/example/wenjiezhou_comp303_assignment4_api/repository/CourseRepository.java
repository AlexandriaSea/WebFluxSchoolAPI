package com.example.wenjiezhou_comp303_assignment4_api.repository;

import com.example.wenjiezhou_comp303_assignment4_api.model.Course;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {
}
