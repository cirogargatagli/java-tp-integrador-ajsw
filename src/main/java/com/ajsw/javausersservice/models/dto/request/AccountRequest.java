package com.ajsw.javausersservice.models.dto.request;

import com.ajsw.javausersservice.models.entities.Role;
import lombok.Getter;
import lombok.Setter;

public class AccountRequest {
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private boolean active;

    @Getter
    @Setter
    private int id_role;
}
