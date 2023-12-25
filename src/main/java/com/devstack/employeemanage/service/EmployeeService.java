package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.EmployeeDto;
import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public String saveEmployee(EmployeeDto employeeDto);

    public String updateEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployeeById(long id);

    public String deleteEmployee(long id);

    public List<EmployeeDto> getAllEmployees();

}
