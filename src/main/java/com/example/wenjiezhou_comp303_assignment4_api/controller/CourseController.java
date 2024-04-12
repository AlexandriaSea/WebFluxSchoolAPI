package com.example.wenjiezhou_comp303_assignment4_api.controller;

import com.example.wenjiezhou_comp303_assignment4_api.model.Course;
import com.example.wenjiezhou_comp303_assignment4_api.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/courses")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public Flux<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Mono<Course> addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public Mono<Course> updateCourse(@PathVariable String id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCourse(@PathVariable String id) {
        return courseService.deleteCourse(id);
    }

    @GetMapping("/student/{studentId}")
    public Flux<Course> getCoursesForStudent(@PathVariable String studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }
}
