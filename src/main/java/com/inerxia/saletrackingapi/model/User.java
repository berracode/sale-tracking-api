package com.inerxia.saletrackingapi.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="password")
    private String password;

	@Column(name="role_id")
	private Integer roleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id", insertable = false, updatable = false, nullable = false)
	private Role roleFk;


	

}
