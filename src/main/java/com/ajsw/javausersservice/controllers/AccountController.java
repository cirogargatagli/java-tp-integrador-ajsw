package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.request.LoginRequest;
import com.ajsw.javausersservice.models.dto.response.AccountResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService _accountService){
        accountService = _accountService;
    }

    @PostMapping()
    public Response createAccount(@Validated @RequestBody AccountRequest accountRequest){
        try {
            return accountService.saveAccount(accountRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

    @PostMapping("/login")
    public AccountResponseDto logIn(@Validated @RequestBody LoginRequest loginRequest){
        try {
            return accountService.logIn(loginRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}