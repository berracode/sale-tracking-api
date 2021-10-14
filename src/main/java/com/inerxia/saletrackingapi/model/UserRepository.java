package com.inerxia.saletrackingapi.model;

import java.util.List;
import java.util.Optional;

import com.inerxia.saletrackingapi.dto.ProductWrapperDto;
import com.inerxia.saletrackingapi.dto.UserRolePermissionsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{
	
    Optional<User> findByEmail(String email);

    @Query("SELECT new com.inerxia.saletrackingapi.dto.UserRolePermissionsDto(u.email, u.firstName, u.lastName, r.id,r.name,rp.permissionId,p.name) FROM User u " +
            "INNER JOIN Role r on u.roleId = r.id " +
            "INNER JOIN RolePermission rp on r.id = rp.roleId " +
            "INNER JOIN Permission p on rp.permissionId = p.id " +
            "WHERE u.email LIKE %:email%")
    List<UserRolePermissionsDto> findUserRoleWithPermission(@Param("email") String email);


}
