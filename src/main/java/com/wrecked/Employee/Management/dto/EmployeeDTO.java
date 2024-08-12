package com.wrecked.Employee.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String FirstName;
    private Integer age;
}

