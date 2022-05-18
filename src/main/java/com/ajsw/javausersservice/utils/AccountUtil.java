package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.AccountRequest;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Role;
import org.springframework.stereotype.Component;

@Component
public class AccountUtil {
    private final HashUtil hashUtil;

    public AccountUtil(HashUtil hashUtil) {
        this.hashUtil = hashUtil;
    }

    public Account createAccount(AccountRequest accountRequest){
        return new Account(
                accountRequest.getEmail(),
                accountRequest.getPassword(),
                accountRequest.isActive(),
                new Role(accountRequest.getId_role())
        );
    }

}
