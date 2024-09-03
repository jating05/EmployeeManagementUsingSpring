package com.wrecked.Employee.Management.dto;


//https://futuretask.blogspot.com/2005/01/java-tip-6-dont-capitalize-first-two.html
//Keep intial two characters as lowercase when naming a property of a bean
//w
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class EmployeeDTO {
    //    @JsonProperty(value = "NName")
    private String name;
    private Long id;
    private Integer age;
    private Boolean isActive;
}