package com.devstack.employeemanage.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", length = 256, nullable = false)
    private Long id;

    @Column(name="user_name", length = 256, nullable = false)
    private String username;

    @Column(name="user_email", length = 256, nullable = false)
    private String email;

    @Column(name="user_password", length = 256, nullable = false)
    private String password;

}
