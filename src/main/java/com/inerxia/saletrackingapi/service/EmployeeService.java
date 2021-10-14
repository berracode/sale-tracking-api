package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataConstraintViolationException;
import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.Employee;
import com.inerxia.saletrackingapi.model.EmployeeRepository;
import com.inerxia.saletrackingapi.model.Provider;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee){
        if(Objects.nonNull(employee.getId())){
            Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
            if(employeeOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.provider");
            }
        }

        try {
            return employeeRepository.save(employee);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.employee "+e.toString());
        }
    }
}
