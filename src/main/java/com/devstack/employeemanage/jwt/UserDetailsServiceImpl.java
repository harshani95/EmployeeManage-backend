package com.devstack.employeemanage.jwt;

import com.devstack.employeemanage.entity.User;
import com.devstack.employeemanage.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User selectedUser = userRepo.findByEmail(email);
        if (selectedUser == null) {
            throw new UsernameNotFoundException("User not found", null);
        }

        return new org.springframework.security.core.userdetails.User(
                selectedUser.getEmail(),
                selectedUser.getPassword(),
                new ArrayList<>());
    }
}

