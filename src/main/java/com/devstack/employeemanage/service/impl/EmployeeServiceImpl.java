package com.devstack.employeemanage.service.impl;

import com.devstack.employeemanage.dto.EmployeeDto;
import com.devstack.employeemanage.entity.Employee;
import com.devstack.employeemanage.exception.NotFoundException;
import com.devstack.employeemanage.repository.EmployeeRepo;
import com.devstack.employeemanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public String saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(

                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getContactNumber()
        );

        employeeRepo.save(employee);
        return employee.getFirstName() + "saved";
    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {
        if(employeeRepo.existsById(employeeDto.getId())){
            Employee employee = employeeRepo.getReferenceById(employeeDto.getId());

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employee.setContactNumber(employeeDto.getContactNumber());

            employeeRepo.save(employee);
            return employee.getFirstName() + "Updated";
        }
        else {
            throw new NotFoundException("No data Found for that ID");
        }
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        if(employeeRepo.existsById(id)) {
            Employee employee = employeeRepo.getReferenceById(id);

            EmployeeDto employeeDto = new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );

            return employeeDto;
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
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> EmployeeDtoList = employeeRepo.findAll();
        List <EmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee : EmployeeDtoList){
            EmployeeDto EmployeeDto = new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );
            employeeDtos.add(EmployeeDto);
        }
        return employeeDtos;
    }
}
