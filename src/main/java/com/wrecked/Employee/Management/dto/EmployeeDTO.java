package com.wrecked.Employee.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
//@Setter
//@Getter
//@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String FirstName;
    private Integer age;

    public String setFirstName(){
        System.out.println("Ran 1");
        return FirstName;
    }

    public String setfirstName(){
        System.out.println("Ran 2");
        return FirstName;
    }

//    public Integer gefdtffge() {
//        System.out.println("added getAgeDebug");
//        return Age+1;
//    }
//
//    public Integer gefdtffge() {
//        System.out.println("added getAgeDebug");
//        return Age+1;
//    }
//    public Integer getffdfge() {
//        System.out.println("it is first using this weird function");
//        System.out.println("getAgeDebug");
//        return Age;
//    }
//    public Integer getffge() {
//        System.out.println("it is secondusing this weird function");
//        System.out.println("getAgeDebug");
//        return Age;
//    }
//
//    public Integer getId(){
//        System.out.println("Test");
//        return Age;
//    }
//    public Integer getAge() {
//        return Age;
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
////    public EmployeeDTO() {}
//
//
//    public void setAge(Integer Age) {
//        this.Age = Age;
//    }
//
//    public void setId(Long Id) {
//        this.Id = Id;
//    }
//
//    public void setName(String Name) {
//        System.out.println("[NameJacksonDebug]");
//        this.Name = Name;
//    }
//
//    public EmployeeDTO(Integer Age, Long Id, String Name){
//        System.out.println("[JacksonDebug]");
//        this.Age=Age;
//        this.Id=Id;
//        this.Name=Name;
//    }
}

