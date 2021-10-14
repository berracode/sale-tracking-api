package com.inerxia.saletrackingapi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	private Integer id;
	
	private String email;
	
	private String firstName;

	private String lastName;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

	private Integer roleId;

	private RoleDto roleDtoFk;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public RoleDto getRoleDtoFk() {
		return roleDtoFk;
	}

	public void setRoleDtoFk(RoleDto roleDtoFk) {
		this.roleDtoFk = roleDtoFk;
	}

	@Override
	public String toString() {
		return "UserDto{" +
				"id=" + id +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				", roleId=" + roleId +
				", roleDtoFk=" + roleDtoFk +
				'}';
	}
}
