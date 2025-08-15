package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.request.RequestUserDto;

public interface UserService {
     String signup(RequestUserDto userDto);
     String login(RequestUserDto userDto);
}
