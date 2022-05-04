package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
}
