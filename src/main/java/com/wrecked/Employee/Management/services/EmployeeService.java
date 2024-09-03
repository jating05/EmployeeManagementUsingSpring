package com.wrecked.Employee.Management.services;
import com.wrecked.Employee.Management.dto.EmployeeDTO;
import com.wrecked.Employee.Management.entity.EmployeeEntity;
import com.wrecked.Employee.Management.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


//    Note: The Below code snippet contains a lot of insights, must read.
//    I have commented it because the return type is not of Optional type , but in production ready applications
//    we should try and use Optional as much as possible.

//    public EmployeeDTO getEmployeeById(Long employeeId) {
//        Method 1
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
//        return modelMapper.map(employeeEntity, EmployeeDTO.class);

//        Description Method 1
//        Here we take take out the value from repos, but since it will give Optional type, so we use
//        orElse will return null incase element is empty in optional and it will return the actual return
//        type of employeeEntity incase optional is not null.

//        Also this case will fail in scenario in case the employeeEntity turns out to be null because in second
//        line when we are using modelmapper then we havent put any scenario which will handle this case
//        And incase of null employeeEntity, modelMapper will not be able to handle it and it will give error.

//      Here orElse statement is mandatory because findById function from JPA return Optional type,
//        However, when  we use orElse, then it unboxes the Optional type of it
//        So basically, findById returns Optional Type
//        Whereas attaching orElse along with it gives us the dataType of element inside the Optional
//        Also, To be noted, .map function is only in Optional class and Stream class


//        Method 2
//        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employeeId);
//        if (optionalEmployeeEntity.isPresent()) {
//            return modelMapper.map(optionalEmployeeEntity.get(), EmployeeDTO.class);
//        } else {
//            // Handle the case where the employee is not found
//            return null; // or throw an exception
//        }

//        Description of Method 2
//        Here in this , remember few points
//        we cant directly use modelMapper on Optional type, so here also , we can use it on optional.get()
//        which will retrieve the actual Data object inside the optional box incase it is present
//        if you want to use this, return type of the function should be Optional<EmployeeDTO>



//        Method 3
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
//        return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class));
//        Note: This  will also require the return datatype to be Optional type.
//    }

    public Optional<EmployeeDTO> getEmployeeById(Long employeeId){
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employeeId);
        return optionalEmployeeEntity.map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));

    }

    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<EmployeeDTO> dtoEntities = entities
                .stream()
                .map(oneEntity -> modelMapper.map(oneEntity, EmployeeDTO.class))
                .collect(Collectors.toList());

        return dtoEntities;

    }

    public Boolean isExistByEmployeeId(Long employeeId){
        return employeeRepository.existsById(employeeId);
    }

//    public Boolean deleteById(Long employeeId){
//        Boolean isExist = isExistByEmployeeId(employeeId);
//        if(!isExist) {
//            throw new NoResourceFoundException("No such employee id exists to delete");
//        }
//    }


    public EmployeeDTO EmployeeAdd(EmployeeDTO obj) {
        System.out.println(obj.getId());
//        Boolean isExist = isExistByEmployeeId(obj.getId());
//        Question: How correct is this way of handling  exceptions.
//        if(!isExist) throw new RuntimeException("Already employee wih given name exist, use put mapping to update");
//        else{
            EmployeeEntity toBeSaved = modelMapper.map(obj, EmployeeEntity.class);
            EmployeeEntity savedEntity = employeeRepository.save(toBeSaved);
            return modelMapper.map(savedEntity, EmployeeDTO.class);
//        }
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO obj){
        boolean isExist = isExistByEmployeeId(obj.getId());
        if(isExist){
            EmployeeEntity objEntity = modelMapper.map(obj, EmployeeEntity.class);
            objEntity.setId(employeeId);
            EmployeeEntity savedEmp = employeeRepository.save(objEntity);
            return modelMapper.map(savedEmp, EmployeeDTO.class);
        }
        else {
            throw new RuntimeException("No such emp id exists to update");
        }
    }
}
