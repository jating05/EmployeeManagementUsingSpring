package com.wrecked.Employee.Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeTable")
public class EmployeeEntity {
    private  String Name;
    private Long id;
    private Integer age;
    private Boolean isActive;
}
