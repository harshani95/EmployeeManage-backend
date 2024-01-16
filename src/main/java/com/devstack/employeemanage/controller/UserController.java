package com.devstack.employeemanage.controller;

import com.devstack.employeemanage.dto.request.RequestUserDto;
import com.devstack.employeemanage.service.UserService;
import com.devstack.employeemanage.util.StandardResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/users")
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



}
