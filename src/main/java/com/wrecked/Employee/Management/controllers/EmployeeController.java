package com.wrecked.Employee.Management.controllers;


import com.wrecked.Employee.Management.dto.EmployeeDTO;
import com.wrecked.Employee.Management.services.EmployeeService;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployee() {
        return "Hello this is just for test";
    }

//    Note: We cant return optional type from here, since jackson wont be able to unbox it
//    So we will need to unbox it
    @GetMapping(path = "/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
//        Method 1:
//        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId).get());
//        Note: This is not the best way to write it as
//        1. we havent checked the isPresent before using the .get function in case it is null, then .get
//        will give error
//        2. Incase of null return we should return ResponseEntity.notFound.build()
        Optional<EmployeeDTO> optionalEmployeeDTO = employeeService.getEmployeeById(employeeId);
        return optionalEmployeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());

//        Question: Here how ResponseEntity<EmployeeDTO> is handled here in case of orElse statement


    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> allEmp = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmp);
    }

    @PostMapping(path = "/add")
    public EmployeeDTO EmployeeAdd(@RequestBody EmployeeDTO obj){
        EmployeeDTO savedEmp = employeeService.EmployeeAdd(obj);
        return obj;
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO obj){
        return employeeService.updateEmployeeById(employeeId, obj);
    }

}
