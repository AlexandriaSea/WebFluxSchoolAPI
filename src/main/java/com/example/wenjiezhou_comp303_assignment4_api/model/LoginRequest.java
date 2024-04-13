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

/**
 * Represents a login request entity used to encapsulate user login credentials.
 * This class serves as a data transfer object (DTO) for carrying login details
 * from the client to the server during the authentication process.
 */

@Data
@Builder
@AllArgsConstructor
@ToString
public class LoginRequest {
    private String email;
    private String password;
}
