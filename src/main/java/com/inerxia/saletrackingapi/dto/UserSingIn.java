package com.inerxia.saletrackingapi.dto;


import java.util.List;

public class UserSingIn {
    private String token;
    private String tokenType;
    private RoleDto roleDto;
    private List<UserRolePermissionsDto> userRolePermissionsDtoList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public List<UserRolePermissionsDto> getUserRolePermissionsDtoList() {
        return userRolePermissionsDtoList;
    }

    public void setUserRolePermissionsDtoList(List<UserRolePermissionsDto> userRolePermissionsDtoList) {
        this.userRolePermissionsDtoList = userRolePermissionsDtoList;
    }

    public RoleDto getRoleDto() {
        return roleDto;
    }

    public void setRoleDto(RoleDto roleDto) {
        this.roleDto = roleDto;
    }
}
