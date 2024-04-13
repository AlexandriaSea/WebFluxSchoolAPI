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
 * Represents a student entity as stored in the MongoDB database.
 * This class is annotated with Spring Data MongoDB annotations to define
 * how students are stored and managed in the MongoDB collection.
 */

@Data
@Builder
@AllArgsConstructor
@Document(collection = "students")
@ToString
public class Student {

    @Id
    private String _id;

    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String gender;

    private String nationality;

    private String address;

    private String phone;

    private String email;

    private String password;
}
