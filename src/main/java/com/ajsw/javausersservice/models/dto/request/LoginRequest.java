package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

public class LoginRequest {
    @Getter
    @Setter
    @Email(message = "A valid email must be inserted")
    public String email;

    @Getter
    @Setter
    public String password;
}
