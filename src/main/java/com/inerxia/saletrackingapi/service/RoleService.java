package com.inerxia.saletrackingapi.service;

import com.inerxia.saletrackingapi.exception.DataNotFoundException;
import com.inerxia.saletrackingapi.model.Role;
import com.inerxia.saletrackingapi.model.RoleRepository;
import com.inerxia.saletrackingapi.model.User;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(Integer id) {
        System.out.println("role: "+id);
        if (Objects.isNull(id)) {
            throw new ObjectNotFoundException(id, "Role not found");
        }
        return roleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Role not found"));
    }
}
