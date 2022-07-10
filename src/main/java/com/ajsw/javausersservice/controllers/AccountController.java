package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.JwtUserDetails;
import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.dto.request.LoginRequest;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.services.AccountService;
import com.ajsw.javausersservice.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final JwtService jwtService;

    @Autowired
    public AccountController(AccountService _accountService, JwtService jwtService){
        accountService = _accountService;
        this.jwtService = jwtService;
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
    public String logIn(@Validated @RequestBody LoginRequest loginRequest){
        try {
            return accountService.logIn(loginRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST\n");
        }
    }
}