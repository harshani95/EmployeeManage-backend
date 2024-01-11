package com.devstack.employeemanage.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", length = 256, nullable = false)
    private Long id;

    @Column(name="user_firstname", length = 256, nullable = false)
    private String firstName;

    @Column(name="user_lastname", length = 256, nullable = false)
    private String lastName;

    @Column(name="username", length = 256, nullable = false)
    private String username;

    @NaturalId(mutable = true)
    @Column(name="user_email", length = 256, nullable = false)
    private String email;

    @Column(name="user_password", length = 256, nullable = false)
    private String password;

    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isEnabled = false;

}
