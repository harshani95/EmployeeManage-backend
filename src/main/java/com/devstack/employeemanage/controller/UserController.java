package com.devstack.employeemanage.controller;

import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.service.UserService;
import com.devstack.employeemanage.service.impl.ApplicationUserServiceImpl;
import com.devstack.employeemanage.util.JwtUtil;
import com.devstack.employeemanage.util.StandardResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody RequestUserDto userDto){
        String name =userService.signup(userDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"user was saved!", name),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public ResponseEntity<StandardResponse> loginUser(@RequestBody RequestUserDto userDto) {

           String token = userService.login(userDto);

        return new ResponseEntity<>(
                new StandardResponse(HttpStatus.OK.value(), "Authentication successful", token),
                HttpStatus.OK
        );
    }



}
