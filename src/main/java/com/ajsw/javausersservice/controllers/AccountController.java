package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.request.LoginRequest;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entity.Account;
import com.ajsw.javausersservice.services.AccountService;
import com.ajsw.javausersservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService _accountService){
        accountService = _accountService;
    }

    @PostMapping()
    public Response createAccount(@Validated @RequestBody AccountRequest accountRequest){
        try {
            Account account = new Account(accountRequest.getEmail(), accountRequest.getPassword(), accountRequest.isActive(), accountRequest.getId_role());
            return accountService.saveAccount(account);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }

//    @PostMapping()
//    public OAuth2ResourceServerProperties.Jwt Login(@Validated @RequestBody LoginRequest loginRequest){
//        try {
//
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
//        }
//    }
}