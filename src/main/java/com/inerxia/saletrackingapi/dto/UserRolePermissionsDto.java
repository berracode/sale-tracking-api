package com.inerxia.saletrackingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class UserRolePermissionsDto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer roleId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String roleName;


    private Integer permissionId;

    @NotBlank
    private String permissionName;

    public UserRolePermissionsDto(Integer roleId, String roleName, Integer permissionId, String permissionName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.permissionId = permissionId;
        this.permissionName = permissionName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
