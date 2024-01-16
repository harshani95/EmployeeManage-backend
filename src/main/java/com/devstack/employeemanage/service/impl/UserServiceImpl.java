package com.devstack.employeemanage.service.impl;
import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.entity.User;

import com.devstack.employeemanage.repository.UserRepo;
import com.devstack.employeemanage.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    @Override
    public String signup(RequestUserDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword())
        );

        userRepo.save(user);
        return user.getFirstName()+ " saved";
        }

}
