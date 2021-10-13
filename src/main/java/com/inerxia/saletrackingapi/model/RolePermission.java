package com.inerxia.saletrackingapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="role_permission")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="permission_id", insertable = false, updatable = false, nullable = false)
    private Permission permissionFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", insertable = false, updatable = false, nullable = false)
    private Role roleFk;

}
