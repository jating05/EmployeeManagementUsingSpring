package com.wrecked.Employee.Management.services;
import com.wrecked.Employee.Management.entity.EmployeeEntity;
import com.wrecked.Employee.Management.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getAllEmployee(){
//        List<EmployeeEntity> entities = employeeRepository.findAll().orElse(null);
        return null;
    }


}
