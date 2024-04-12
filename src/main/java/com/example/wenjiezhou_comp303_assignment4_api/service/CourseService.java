package com.example.wenjiezhou_comp303_assignment4_api.service;

import com.example.wenjiezhou_comp303_assignment4_api.model.Course;
import com.example.wenjiezhou_comp303_assignment4_api.repository.CourseRepository;
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
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Flux<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Mono<Course> getCourseById(String id) {
        return courseRepository.findById(id);
    }

    public Mono<Course> addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Mono<Course> updateCourse(String id, Course updatedCourse) {
        return courseRepository.findById(id)
                .flatMap(course -> {
                    updatedCourse.set_id(id);
                    return courseRepository.save(updatedCourse);
                })
                .switchIfEmpty(Mono.empty());
    }

    public Mono<Void> deleteCourse(String id) {
        return courseRepository.findById(id)
                .flatMap(course -> courseRepository.delete(course));
    }

    public Flux<Course> getCoursesByStudentId(String studentId) {
        return enrollmentRepository.findByStudentId(studentId)
                .flatMap(enrollment -> courseRepository.findById(enrollment.getCourseId()));
    }
}
