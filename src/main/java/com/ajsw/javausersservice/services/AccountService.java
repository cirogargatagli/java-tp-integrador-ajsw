package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
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

    public Response saveAccount(Account account){
        String hashPassword = DigestUtils.sha256Hex(account.getPassword());
        account.setPassword(hashPassword);
        Account accountCreated = accountRepository.save(account);
        EntityCreatedResponse response = new EntityCreatedResponse(accountCreated.getIdAccount(), 200, "Account created successfully.");
        return response;
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).get();
    }
}
