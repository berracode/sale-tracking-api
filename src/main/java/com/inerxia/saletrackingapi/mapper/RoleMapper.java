package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.RoleDto;
import com.inerxia.saletrackingapi.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDto, Role>{
}
