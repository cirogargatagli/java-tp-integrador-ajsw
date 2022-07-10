package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.request.LoginRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.repositories.interfaces.IAccountRepository;
import com.ajsw.javausersservice.utils.AccountUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {
    private final IAccountRepository accountRepository;
    private final AccountUtil accountUtil;
    private final String nameEntity = "Account";
    private final ModelMapper mapper;
    private final JwtService jwtService;

    @Autowired
    public AccountService(IAccountRepository accountRepository, AccountUtil accountUtil, ModelMapper mapper, JwtService jwtService){
        this.accountRepository = accountRepository;
        this.accountUtil = accountUtil;
        this.mapper = mapper;
        this.jwtService = jwtService;
    }

    public Response saveAccount(AccountRequest accountRequest){
        Account account = accountUtil.createAccount(accountRequest);
        Account accountCreated = accountRepository.save(account);
        return new EntityCreatedResponse(accountCreated.getIdAccount(), nameEntity);
    }

    public String logIn(LoginRequest loginRequest){
        Optional<Account> accountOptional = accountRepository.getAccountByEmailAndPassword(loginRequest.email, loginRequest.password);
        if(accountOptional.isPresent()){
            Account existingAccount = accountOptional.get();
            if (Objects.equals(loginRequest.password, existingAccount.getPassword())) {
                return jwtService.generateToken(existingAccount);
            }
        }
        throw new RuntimeException("Account invalid");
    }

    public Account getAccountById(int id){
        return accountRepository.findById(id).get();
    }
}
