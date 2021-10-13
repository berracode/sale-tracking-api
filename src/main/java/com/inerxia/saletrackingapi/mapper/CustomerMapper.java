package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.CustomerDto;
import com.inerxia.saletrackingapi.model.Customer;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), uses = {UserMapper.class})
public interface CustomerMapper extends EntityMapper<CustomerDto, Customer>{
}
