package com.example.student.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto addressDto;
}
