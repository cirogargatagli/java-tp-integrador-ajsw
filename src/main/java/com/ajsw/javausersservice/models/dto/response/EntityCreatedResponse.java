package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

public class EntityCreatedResponse extends Response{
    @Getter
    @Setter
    public int id;

    public EntityCreatedResponse() {
    }

    public EntityCreatedResponse(int id, int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.id = id;
    }
}
