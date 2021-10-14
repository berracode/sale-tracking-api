package com.inerxia.saletrackingapi.model;


import javax.persistence.*;

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

    public Permission getPermissionFk() {
        return permissionFk;
    }

    public void setPermissionFk(Permission permissionFk) {
        this.permissionFk = permissionFk;
    }

    public Role getRoleFk() {
        return roleFk;
    }

    public void setRoleFk(Role roleFk) {
        this.roleFk = roleFk;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", permissionId=" + permissionId +
                ", roleId=" + roleId +
                ", permissionFk=" + permissionFk +
                ", roleFk=" + roleFk+
                '}';
    }
}
