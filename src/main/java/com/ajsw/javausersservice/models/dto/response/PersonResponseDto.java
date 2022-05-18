package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class PersonResponseDto {
    @Getter
    @Setter
    public String firstName;

    @Getter
    @Setter
    public String lastName;

    @Getter
    @Setter
    public String phone;

    @Getter
    @Setter
    public AddressResponseDto address;

    @Getter
    @Setter
    public AccountResponseDto account;
}
