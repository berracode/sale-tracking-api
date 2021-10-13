package com.inerxia.saletrackingapi.dto;


import lombok.Data;

@Data
public class UserDto {

	private Integer id;
	
	private String email;
	
	private String firstName;

	private String lastName;

    private String password;

	private Integer roleId;

	private RoleDto roleDtoFk;



}
