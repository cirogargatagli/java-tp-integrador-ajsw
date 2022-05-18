package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.request.LoginRequest;
import com.ajsw.javausersservice.models.dto.response.AccountResponseDto;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.repositories.interfaces.IAccountRepository;
import com.ajsw.javausersservice.utils.AccountUtil;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class AccountService {
    private final IAccountRepository accountRepository;
    private final AccountUtil accountUtil;
    private final String nameEntity = "Account";
    private final ModelMapper mapper;

    @Autowired
    public AccountService(IAccountRepository accountRepository, AccountUtil accountUtil, ModelMapper mapper){
        this.accountRepository = accountRepository;
        this.accountUtil = accountUtil;
        this.mapper = mapper;
    }

    public Response saveAccount(AccountRequest accountRequest){
        Account account = accountUtil.createAccount(accountRequest);
        Account accountCreated = accountRepository.save(account);
        return new EntityCreatedResponse(accountCreated.getIdAccount(), nameEntity);
    }

    public AccountResponseDto logIn(LoginRequest loginRequest){
        return mapper.map(accountRepository.getAccountByEmailAndPassword(loginRequest.email, loginRequest.password), AccountResponseDto.class);
    }

    public Account getAccountById(int id){
        return accountRepository.findById(id).get();
    }
}
