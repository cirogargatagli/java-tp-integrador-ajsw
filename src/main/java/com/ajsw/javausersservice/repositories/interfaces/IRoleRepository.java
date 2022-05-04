package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}