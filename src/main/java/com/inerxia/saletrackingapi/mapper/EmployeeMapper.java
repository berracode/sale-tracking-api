package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.EmployeeDto;
import com.inerxia.saletrackingapi.model.Employee;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {UserMapper.class})
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee>{
}
