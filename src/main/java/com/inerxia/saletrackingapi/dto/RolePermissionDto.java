package com.inerxia.saletrackingapi.dto;


import lombok.Data;

@Data
public class RolePermissionDto {

    private Integer id;

    private Integer permissionId;

    private Integer roleId;

    private PermissionDto permissionDtoFk;

    private RoleDto roleDtoFk;

}
