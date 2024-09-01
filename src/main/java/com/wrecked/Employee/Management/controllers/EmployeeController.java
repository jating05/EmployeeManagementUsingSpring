package com.wrecked.Employee.Management.controllers;


import com.wrecked.Employee.Management.dto.EmployeeDTO;
import com.wrecked.Employee.Management.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployee() {
        return "Hello this is just for test";
    }

    @GetMapping("/{employeeID}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/add")
    public EmployeeDTO EmployeeAdd(@RequestBody EmployeeDTO obj){
        return obj;
    }
}
