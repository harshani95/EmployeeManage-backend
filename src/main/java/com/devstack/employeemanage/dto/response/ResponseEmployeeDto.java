package com.devstack.employeemanage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseEmployeeDto {
    private long id;
    private String fullName;
    private String address;
    private String email;
    private String contactNumber;
}
