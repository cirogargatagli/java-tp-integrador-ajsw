package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.entities.Role;
import com.ajsw.javausersservice.repositories.interfaces.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final IRoleRepository roleRepository;

    @Autowired
    public RoleService(IRoleRepository iRoleRepository){
        roleRepository = iRoleRepository;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id){
        return roleRepository.findById(id).get();
    }
}
