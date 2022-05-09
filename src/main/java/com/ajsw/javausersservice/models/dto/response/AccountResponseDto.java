package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

public class AccountResponseDto {
    @Getter
    @Setter
    public String email;

    @Getter
    @Setter
    public Date createdAt;

    @Getter
    @Setter
    public boolean active;

    @Getter
    @Setter
    public RoleResponseDto role;
}
