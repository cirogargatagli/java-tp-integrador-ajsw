package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

public class AccountRequest {
    @Getter
    @Setter
    @NotNull(message = "Email may not be null")
    @Email(message = "A valid email must be inserted")
    private String email;

    @Getter
    @Setter
    @NotBlank(message = "Password may not be null")
    @Size(min = 8, message = "Password minimum length 8")
    private String password;

    @Getter
    @Setter
    private boolean active;

    @Getter
    @Setter
    @Min(value = 1, message = "A role must be inserted")
    private int id_role;
}
