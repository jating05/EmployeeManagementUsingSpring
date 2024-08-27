package com.wrecked.Employee.Management.controllers;


import com.wrecked.Employee.Management.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public String getEmployee() {
        return "Hello";
    }

    @PostMapping("/add")
    public EmployeeDTO EmployeeAdd(@RequestBody EmployeeDTO obj){
        return obj;
    }
}
