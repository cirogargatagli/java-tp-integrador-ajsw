package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Response {
    @Getter
    @Setter
    public int statusCode;

    @Getter
    @Setter
    public String message;
}