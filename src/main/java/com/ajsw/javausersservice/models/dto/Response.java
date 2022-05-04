package com.ajsw.javausersservice.models.dto;

import lombok.Getter;
import lombok.Setter;

public class Response {
    @Getter
    @Setter
    public int statusCode;

    @Getter
    @Setter
    public String message;
}
