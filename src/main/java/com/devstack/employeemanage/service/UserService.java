package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.entity.User;

public interface UserService {
     public String signup(RequestUserDto userDto);
}
