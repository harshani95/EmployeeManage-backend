package com.devstack.employeemanage.util.mapper;

import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    ResponseEmployeeDto toResponseEmployeeDto(Employee employee);
    Employee toEmployee(RequestEmployeeDto dto);
    List<ResponseEmployeeDto> toResponseEmployeeDtoList(List<Employee> employeeList);
}

