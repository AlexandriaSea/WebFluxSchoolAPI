/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an enrollment entity as stored in the MongoDB database.
 * This class is annotated with Spring Data MongoDB annotations to define
 * how enrollments are stored and managed in the MongoDB collection.
 */

@Data
@Builder
@AllArgsConstructor
@Document(collection = "enrollments")
@ToString
public class Enrollment {

    @Id
    private String _id;

    private String studentId;

    private String courseId;

    private String term;
}
