package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.repositories.interfaces.IAccountRepository;
import com.ajsw.javausersservice.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final IAccountRepository accountRepository;
    private final AccountUtil accountUtil;
    private final String nameEntity = "Account";

    @Autowired
    public AccountService(IAccountRepository accountRepository, AccountUtil accountUtil){
        this.accountRepository = accountRepository;
        this.accountUtil = accountUtil;
    }

    public Response saveAccount(AccountRequest accountRequest){
        Account account = accountUtil.createAccount(accountRequest);
        Account accountCreated = accountRepository.save(account);
        return new EntityCreatedResponse(accountCreated.getIdAccount(), nameEntity);
    }

    public Account getAccountById(int id){
        return accountRepository.findById(id).get();
    }
}
