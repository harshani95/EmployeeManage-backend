package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.EmployeeDto;
import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;

import java.util.List;

public interface EmployeeService {

    public String saveEmployee(RequestEmployeeDto requestEmployeeDto);

    public void updateEmployee(long id, RequestEmployeeDto requestEmployeeDto);

    public ResponseEmployeeDto getEmployeeById(long id);

    public String deleteEmployee(long id);

    public List<ResponseEmployeeDto> getAllEmployees();

}
