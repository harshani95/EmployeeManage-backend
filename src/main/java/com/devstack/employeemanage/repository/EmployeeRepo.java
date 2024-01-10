package com.devstack.employeemanage.repository;

import com.devstack.employeemanage.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

   @Query(value = "SELECT * FROM employee WHERE name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
   public List<Employee> searchEmployees(String searchText, Pageable pageable);

   @Query(value = "SELECT COUNT(*) FROM employee WHERE name LIKE ?1 OR address LIKE ?1", nativeQuery = true)
   public Long countEmployees(String searchText);

}
