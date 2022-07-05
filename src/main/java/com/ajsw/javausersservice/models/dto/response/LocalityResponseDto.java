package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class LocalityResponseDto {
    @Getter
    @Setter
    public int id;
    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String postalCode;
}
