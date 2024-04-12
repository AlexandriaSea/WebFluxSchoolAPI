package com.example.wenjiezhou_comp303_assignment4_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
