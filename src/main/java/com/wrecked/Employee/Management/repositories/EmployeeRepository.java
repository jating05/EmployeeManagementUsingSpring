package com.wrecked.Employee.Management.repositories;


import com.wrecked.Employee.Management.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//interface extends interface
//Class extends class
//class implementds interface


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
