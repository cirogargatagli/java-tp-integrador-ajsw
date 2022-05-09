package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ClientResponseDto extends PersonResponseDto {
    @Getter
    @Setter
    public AddressResponseDto address;
}
