package com.devstack.employeemanage.service.impl;

import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.dto.response.paginated.PaginatedEmployeeResponseDto;
import com.devstack.employeemanage.entity.Employee;
import com.devstack.employeemanage.exception.NotFoundException;
import com.devstack.employeemanage.repository.EmployeeRepo;
import com.devstack.employeemanage.service.EmployeeService;
import com.devstack.employeemanage.util.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final  EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo,  EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public String saveEmployee(RequestEmployeeDto requestEmployeeDto) {
        Employee employee = new Employee(

                requestEmployeeDto.getName(),
                requestEmployeeDto.getAddress(),
                requestEmployeeDto.getEmail(),
                requestEmployeeDto.getContactNumber()
        );

        employeeRepo.save(employee);
        return employee.getName()+ " saved";
    }

    @Override
    public void updateEmployee(long id, RequestEmployeeDto requestEmployeeDto) {
        Optional<Employee> selectedEmployee = employeeRepo.findById(id);
        if (selectedEmployee.isEmpty()) {
            throw new NotFoundException("Employee Not Found");
        }
        Employee employee = selectedEmployee.get();
        employee.setName(requestEmployeeDto.getName());
        employee.setAddress(requestEmployeeDto.getAddress());
        employee.setEmail(requestEmployeeDto.getEmail());
        employee.setContactNumber(requestEmployeeDto.getContactNumber());

        employeeRepo.save(employee);
    }

    @Override
    public ResponseEmployeeDto getEmployeeById(long id) {

       /* if(employeeRepo.existsById(id)) {
            Employee employee = employeeRepo.getReferenceById(id);

            ResponseEmployeeDto responseEmployeeDto = new ResponseEmployeeDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );

            return responseEmployeeDto;
        }
        else {
            throw new NotFoundException("No Employee");
        }*/

        Optional<Employee> selectedEmployee = employeeRepo.findById(id);
        if (selectedEmployee.isEmpty()) {
            throw new NotFoundException("Employee Not Found");
        }
        return employeeMapper.toResponseEmployeeDto(selectedEmployee.get());
    }

    @Override
    public void deleteEmployee(long id) {

        /*if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return id + " deleted";
        }
        else{
            throw new NotFoundException("No Employee For Delete");
        }*/

        Optional<Employee> selectedEmployee = employeeRepo.findById(id);
        if (selectedEmployee.isEmpty()) {
            throw new NotFoundException("Employee Not Found");
        }
        employeeRepo.deleteById(selectedEmployee.get().getId());
    }

    @Override
    public PaginatedEmployeeResponseDto getAllEmployees(String searchText, int page, int size) {
        searchText = "%" + searchText + "%";
        List<Employee> employees = employeeRepo.searchEmployees(searchText, PageRequest.of(page, size));
        long employeeCount = employeeRepo.countEmployees(searchText);
        List<ResponseEmployeeDto> responseEmployeeDtos = employeeMapper.toResponseEmployeeDtoList(employees);
        return new PaginatedEmployeeResponseDto(
               employeeCount,
                responseEmployeeDtos
        );
    }


   /* @Override
    public List<ResponseEmployeeDto> getAllEmployees() {
        List<Employee> EmployeeDtoList = employeeRepo.findAll();
        List <ResponseEmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee : EmployeeDtoList){
            ResponseEmployeeDto EmployeeDto = new ResponseEmployeeDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getEmail(),
                    employee.getContactNumber()
            );
            employeeDtos.add(EmployeeDto);
        }
        return employeeDtos;
    }*/

    /*@Override
    public List<ResponseEmployeeDto> getEmployeeByName(String name) {

        List<Employee> employees = employeeRepo.findAllByNameContainingIgnoreCase(name);

        if (employees.size() != 0) {
            List<ResponseEmployeeDto> responseEmployeeDtos = modelMapper.
                    map(employees, new TypeToken<List<ResponseEmployeeDto>>() {
                    }.getType());
            return responseEmployeeDtos;
        }
        return null;
    }*/

        /*if (!employees.isEmpty()) {
            // Use ModelMapper to map the entities to DTOs
            List<ResponseEmployeeDto> responseEmployeeDtos = employeeMapper.toResponseEmployeeDtoList(employees);
            return responseEmployeeDtos;
        }
     else {
            throw new NotFoundException("No results!!!");
        }*/


}
