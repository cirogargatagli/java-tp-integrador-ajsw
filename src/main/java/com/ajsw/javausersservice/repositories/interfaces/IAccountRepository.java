package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
}
