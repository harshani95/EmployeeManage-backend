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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id", length = 100)
    private long id;

    @Column(name="name", length = 256, nullable = false)
    private String name;

    @Column(name="address", length = 256, nullable = false)
    private String address;

    @NaturalId(mutable = true)
    @Column(name="email", length = 100)
    private String email;

    @Column(name="contact_number", length = 100, nullable = false)
    private String contactNumber;

    public Employee(String name, String address, String email, String contactNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
    }
}
