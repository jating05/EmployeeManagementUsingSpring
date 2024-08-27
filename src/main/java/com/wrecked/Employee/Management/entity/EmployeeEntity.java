package com.wrecked.Employee.Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeTable")
public class EmployeeEntity {
    private  String Name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer age;
    private Boolean isActive;
}
