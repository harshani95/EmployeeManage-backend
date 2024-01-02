package com.devstack.employeemanage.service.impl;

import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.entity.Employee;
import com.devstack.employeemanage.exception.NotFoundException;
import com.devstack.employeemanage.repository.EmployeeRepo;
import com.devstack.employeemanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public String saveEmployee(RequestEmployeeDto requestEmployeeDto) {
        Employee employee = new Employee(

                requestEmployeeDto.getFullName(),
                requestEmployeeDto.getAddress(),
                requestEmployeeDto.getEmail(),
                requestEmployeeDto.getContactNumber()
        );

        employeeRepo.save(employee);
        return employee.getFullName()+ " saved";
    }

    @Override
    public void updateEmployee(long id, RequestEmployeeDto requestEmployeeDto) {
        Optional<Employee> selectedEmployee = employeeRepo.findById(id);
        if (selectedEmployee.isEmpty()) {
            throw new NotFoundException("Employee Not Found");
        }
        Employee employee = selectedEmployee.get();
        employee.setFullName(requestEmployeeDto.getFullName());
        employee.setAddress(requestEmployeeDto.getAddress());
        employee.setEmail(requestEmployeeDto.getEmail());
        employee.setContactNumber(requestEmployeeDto.getContactNumber());

        employeeRepo.save(employee);
    }

    @Override
    public ResponseEmployeeDto getEmployeeById(long id) {
        if(employeeRepo.existsById(id)) {
            Employee employee = employeeRepo.getReferenceById(id);

            ResponseEmployeeDto responseEmployeeDto = new ResponseEmployeeDto(
                    employee.getId(),
                    employee.getFullName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );

            return responseEmployeeDto;
        }
        else {
            throw new NotFoundException("No Employee");
        }
    }

    @Override
    public String deleteEmployee(long id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return id + " deleted";
        }
        else{
            throw new NotFoundException("No Employee For Delete");
        }
    }

    @Override
    public List<ResponseEmployeeDto> getAllEmployees() {
        List<Employee> EmployeeDtoList = employeeRepo.findAll();
        List <ResponseEmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee : EmployeeDtoList){
            ResponseEmployeeDto EmployeeDto = new ResponseEmployeeDto(
                    employee.getId(),
                    employee.getFullName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );
            employeeDtos.add(EmployeeDto);
        }
        return employeeDtos;
    }
}
