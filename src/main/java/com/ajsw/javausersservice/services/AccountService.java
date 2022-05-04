package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.entity.Account;
import com.ajsw.javausersservice.repositories.interfaces.IAccountRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository iAccountRepository){
        accountRepository = iAccountRepository;
    }

    public Account saveAccount(Account account){
        String sha256hex = DigestUtils.sha256Hex(account.getPassword());
        account.setPassword(sha256hex);
        Account response = accountRepository.save(account);
        return response;
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).get();
    }
}
