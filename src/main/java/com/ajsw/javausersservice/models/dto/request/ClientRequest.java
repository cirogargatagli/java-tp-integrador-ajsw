package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

public class ClientRequest extends PersonRequest{
    @Getter
    @Setter
    public int idAddress;
}
