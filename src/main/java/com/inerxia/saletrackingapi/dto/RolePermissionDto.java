package com.inerxia.saletrackingapi.dto;



public class RolePermissionDto {

    private Integer id;

    private Integer permissionId;

    private Integer roleId;

    private PermissionDto permissionDtoFk;

    private RoleDto roleDtoFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public PermissionDto getPermissionDtoFk() {
        return permissionDtoFk;
    }

    public void setPermissionDtoFk(PermissionDto permissionDtoFk) {
        this.permissionDtoFk = permissionDtoFk;
    }

    public RoleDto getRoleDtoFk() {
        return roleDtoFk;
    }

    public void setRoleDtoFk(RoleDto roleDtoFk) {
        this.roleDtoFk = roleDtoFk;
    }
}
