package com.devstack.employeemanage.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="employee_id", length = 100)
    private long id;

    @Column(name="first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name="last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name="email", length = 100)
    private String email;

    @Column(name="contact_number", length = 100, nullable = false)
    private int contactNumber;
}
