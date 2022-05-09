package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class AddressResponseDto {
    @Getter
    @Setter
    public String street;

    @Getter
    @Setter
    public String numberHouse;

    @Getter
    @Setter
    public LocalityResponseDto locality;
}
