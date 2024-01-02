package com.devstack.employeemanage.controller;

import com.devstack.employeemanage.dto.EmployeeDto;
import com.devstack.employeemanage.dto.request.RequestEmployeeDto;
import com.devstack.employeemanage.dto.response.ResponseEmployeeDto;
import com.devstack.employeemanage.exception.NotFoundException;
import com.devstack.employeemanage.service.impl.EmployeeServiceImpl;
import com.devstack.employeemanage.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin()

public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
       this.employeeService = employeeService;
    }


    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody RequestEmployeeDto requestEmployeeDto) {
         String firstName = employeeService.saveEmployee(requestEmployeeDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Successfully added", firstName), HttpStatus.CREATED
        );
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<StandardResponse> updateEmployee(
            @PathVariable(value = "id") long id,
            @RequestBody RequestEmployeeDto requestEmployeeDto)
    {
        employeeService.updateEmployee(id, requestEmployeeDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Updated Successfully", requestEmployeeDto.getFullName()), HttpStatus.CREATED
        );
    }


    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getEmployeeById(
            @RequestParam(value = "id") long id)
    {
        ResponseEmployeeDto responseEmployeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Employee Data", responseEmployeeDto), HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<StandardResponse> deleteEmployee(@PathVariable(value = "id") long id) throws NotFoundException {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(
                new StandardResponse(200, "Successfully Deleted!!",null), HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-employees")
    public ResponseEntity<StandardResponse> getAllEmployees() {
        List<ResponseEmployeeDto> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(
                new StandardResponse(200, "All Employee List", allEmployees), HttpStatus.OK
        );
    }

}
