package com.ajsw.javausersservice.models.dto.request;

import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Address;
import lombok.Getter;
import lombok.Setter;

public class ClientRequest extends PersonRequest{
    @Getter
    @Setter
    public Address address;
}