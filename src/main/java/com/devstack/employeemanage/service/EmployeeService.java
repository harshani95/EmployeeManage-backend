package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.dto.response.paginated.PaginatedEmployeeResponseDto;

public interface EmployeeService {

     String saveEmployee(RequestEmployeeDto requestEmployeeDto);

     void updateEmployee(long id, RequestEmployeeDto requestEmployeeDto);

     ResponseEmployeeDto getEmployeeById(long id);

    void deleteEmployee(long id);

     PaginatedEmployeeResponseDto getAllEmployees(String searchText, int page, int size);

}
