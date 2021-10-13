package com.inerxia.saletrackingapi.mapper;

import com.inerxia.saletrackingapi.dto.RolePermissionDto;
import com.inerxia.saletrackingapi.model.RolePermission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, PermissionMapper.class})
public interface RolePermissionMapper extends EntityMapper<RolePermissionDto, RolePermission>{
}
