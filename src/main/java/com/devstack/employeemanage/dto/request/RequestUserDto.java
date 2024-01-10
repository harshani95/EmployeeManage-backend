package com.devstack.employeemanage.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
