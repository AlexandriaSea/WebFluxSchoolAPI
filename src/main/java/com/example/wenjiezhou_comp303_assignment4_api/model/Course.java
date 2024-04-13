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
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Represents a course entity as stored in the MongoDB database.
 * This class is annotated with Spring Data MongoDB annotations to define
 * how courses are stored and managed in the MongoDB collection.
 */

@Data
@Builder
@AllArgsConstructor
@Document(collection = "courses")
@ToString
public class Course {

    @Id
    private String _id;

    private String code;

    private String title;

    private int hour;

    private String campus;

    private String method;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate doc;

    private String professor;
}
