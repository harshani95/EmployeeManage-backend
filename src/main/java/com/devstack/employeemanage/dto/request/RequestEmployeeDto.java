package com.devstack.employeemanage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestEmployeeDto {
    private String fullName;
    private String address;
    private String email;
    private String contactNumber;
}
