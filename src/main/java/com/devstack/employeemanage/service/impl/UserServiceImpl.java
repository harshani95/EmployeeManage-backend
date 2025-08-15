package com.devstack.employeemanage.service.impl;
import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.entity.User;

import com.devstack.employeemanage.repository.UserRepo;
import com.devstack.employeemanage.service.UserService;

import com.devstack.employeemanage.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public String signup(RequestUserDto userDto) {
        User user = new User(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getRole(),
                passwordEncoder.encode(userDto.getPassword())
        );
        userRepo.save(user);
        return user.getUsername()+ " saved";
        }

    @Override
    public String login(RequestUserDto userDto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(),
                        userDto.getPassword()));
        User user = userRepo.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String jwt = jwtUtil.generateToken(user);
        return jwt;
    }

}
