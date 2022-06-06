package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PersonRequest {
    @Getter
    @Setter
    @NotBlank(message = "First name may not be blank")
    public String firstName;

    @Getter
    @Setter
    @NotBlank(message = "Last name may not be blank")
    public String lastName;

    @Getter
    @Setter
    @NotBlank(message = "Phone may not be blank")
    public String phone;

    @Getter
    @Setter
    public AddressRequest addressRequest;

    @Getter
    @Setter
    public AccountRequest accountRequest;
}