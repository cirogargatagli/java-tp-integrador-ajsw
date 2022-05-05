package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Getter
    @Setter
    public String email;

    @Getter
    @Setter
    public String password;
}
