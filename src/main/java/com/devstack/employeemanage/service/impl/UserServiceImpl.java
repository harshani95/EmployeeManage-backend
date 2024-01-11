package com.devstack.employeemanage.service.impl;

import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.entity.User;
import com.devstack.employeemanage.exception.UserAlreadyExistsException;
import com.devstack.employeemanage.repository.UserRepo;
import com.devstack.employeemanage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(RequestUserDto userDto) {

    }

    @Override
    public boolean verifyUser(String type, String token) {
        return false;
    }


}
