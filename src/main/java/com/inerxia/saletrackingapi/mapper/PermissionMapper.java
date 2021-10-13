package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.PermissionDto;
import com.inerxia.saletrackingapi.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends EntityMapper<PermissionDto, Permission>{
}
