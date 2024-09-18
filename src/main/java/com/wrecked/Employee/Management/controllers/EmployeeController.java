package com.wrecked.Employee.Management.controllers;


import com.wrecked.Employee.Management.advice.CustomEx;
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
//        Answer: In case of orElse statement, we are returning ResponseEntity.notFound().build() which will return
//        ResponseEntity<Void> type, If you assign the result of the function to a variable of type
//        ResponseEntity<EmployeeDTO> and the function returns ResponseEntity<Void>,
//        it will not give any compile-time error because ResponseEntity<Void> is
//        compatible with ResponseEntity<EmployeeDTO> when the body is not used.
//        However, if you try to access the EmployeeDTO object through that variable,
//        it will result in a NullPointerException at runtime because the body is null.

    }

    @GetMapping("exceptionTestOutside")
    public ResponseEntity<EmployeeDTO> thisIsExceptionTest(){
//        throw new RuntimeException("This is just a test");
        throw new CustomEx("Test Message in Controller");
    }


    @GetMapping("exceptionTestInside")
    public ResponseEntity<EmployeeDTO> thisIsExceptionTestInside(){
        System.out.println("Here we are a line Above the function call without returning anything");
        Optional<EmployeeDTO> optionalEmployeeDTO = employeeService.testExceptionServiceInside();
        System.out.println("Here we are a line below the function call without returning anything");
        System.out.println(optionalEmployeeDTO.isPresent());
        return optionalEmployeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> allEmp = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmp);
    }

    @PostMapping(path = "/add")
    public EmployeeDTO EmployeeAdd(@RequestBody EmployeeDTO obj){
        EmployeeDTO savedEmp = employeeService.EmployeeAdd(obj);
        return savedEmp;
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployeeById(@PathVariable Long employeeId, @RequestBody EmployeeDTO obj){
        return employeeService.updateEmployeeById(employeeId, obj);
    }

}
