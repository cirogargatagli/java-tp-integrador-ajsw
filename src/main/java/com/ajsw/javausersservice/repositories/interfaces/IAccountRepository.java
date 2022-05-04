package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
}
