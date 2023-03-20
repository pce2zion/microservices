package com.example.student.student.models.responsemodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {
    private String firstName;
    private String lastName;
    private String email;
    private AddressResponse addressResponse;
}
