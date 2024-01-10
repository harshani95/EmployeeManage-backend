package com.devstack.employeemanage.service;

import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.dto.response.paginated.PaginatedEmployeeResponseDto;

public interface EmployeeService {

    public String saveEmployee(RequestEmployeeDto requestEmployeeDto);

    public void updateEmployee(long id, RequestEmployeeDto requestEmployeeDto);

    public ResponseEmployeeDto getEmployeeById(long id);

    public void deleteEmployee(long id);

   // public List<ResponseEmployeeDto> getAllEmployees();

    public PaginatedEmployeeResponseDto getAllEmployees(String searchText, int page, int size);

}
