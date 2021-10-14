package com.inerxia.saletrackingapi.dto;

public class UserWrapperDto {

    private String email;

    private String firstName;

    private String lastName;

    private RoleDto roleDtoFk;

    public UserWrapperDto(String email, String firstName, String lastName,  RoleDto roleDtoFk) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleDtoFk = roleDtoFk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public RoleDto getRoleDtoFk() {
        return roleDtoFk;
    }

    public void setRoleDtoFk(RoleDto roleDtoFk) {
        this.roleDtoFk = roleDtoFk;
    }
}
