package com.devstack.employeemanage.repository;

import com.devstack.employeemanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
