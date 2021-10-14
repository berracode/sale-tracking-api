package com.inerxia.saletrackingapi.facade;

import com.inerxia.saletrackingapi.dto.UserDto;
import com.inerxia.saletrackingapi.dto.UserSingUpDto;
import com.inerxia.saletrackingapi.exception.InvalidRoleUserException;
import com.inerxia.saletrackingapi.mapper.EmployeeMapper;
import com.inerxia.saletrackingapi.mapper.UserMapper;
import com.inerxia.saletrackingapi.model.Employee;
import com.inerxia.saletrackingapi.service.EmployeeService;
import com.inerxia.saletrackingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.inerxia.saletrackingapi.util.Constants.ROLE_CUSTOMER;

@Service
@Transactional
public class EmployeeFacade {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserService userService;
    private UserMapper userMapper;

    public EmployeeFacade(EmployeeService employeeService, EmployeeMapper employeeMapper, UserService userService, UserMapper userMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserSingUpDto createUser(UserSingUpDto userSingUpDto) {
        validatedRoleNotEmployee(userSingUpDto.getUserDto().getRoleId());

        userSingUpDto.getUserDto().setPassword(passwordEncoder.encode(userSingUpDto.getUserDto().getPassword()));
        userSingUpDto.getUserDto().setFirstName(userSingUpDto.getUserDto().getFirstName().toUpperCase());
        userSingUpDto.getUserDto().setLastName(userSingUpDto.getUserDto().getLastName().toUpperCase());

        userSingUpDto.setUserDto(userMapper.toDto(userService.createUser(userMapper.toEntity(userSingUpDto.getUserDto()))));
        Employee employee = new Employee();
        employee.setIdentification(userSingUpDto.getIdentification());
        employee.setName(userSingUpDto.getName());
        employee.setAddress(userSingUpDto.getAddress());
        employee.setPhone(userSingUpDto.getPhone());
        employee.setUserId(userSingUpDto.getUserDto().getId());



        employee = employeeService.createEmployee(employee);
        userSingUpDto.setId(employee.getId());

        return userSingUpDto;

    }

    private void validatedRoleNotEmployee(Integer roleId){
        if(ROLE_CUSTOMER.equals(roleId)){
            throw new InvalidRoleUserException("The role does not correspond to the type of user to be created.");
        }

    }

}
