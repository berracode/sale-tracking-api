package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.mapper.EmployeeMapper;
import com.inerxia.saletrackingapi.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeFacade {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeFacade(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

}
