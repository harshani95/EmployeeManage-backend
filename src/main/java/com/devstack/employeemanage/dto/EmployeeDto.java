package com.devstack.employeemanage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private int contactNumber;


}
