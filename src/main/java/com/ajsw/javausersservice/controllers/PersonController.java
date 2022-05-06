package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.services.AccountService;
import com.ajsw.javausersservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class PersonController {
    private final AccountService accountService;
    private final RoleService roleService;

    @Autowired
    public PersonController(AccountService _accountService, RoleService _roleService){
        accountService = _accountService;
        roleService = _roleService;
    }
}