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
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name="employee_id", length = 100)
    private long id;

    @Column(name="first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name="last_name", length = 100, nullable = false)
    private String lastName;

    @NaturalId(mutable = true)
    @Column(name="email", length = 100)
    private String email;

    @Column(name="contact_number", length = 100, nullable = false)
    private int contactNumber;

    public Employee(String firstName, String lastName, String email, int contactNumber) {
    }
}
