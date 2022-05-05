package com.ajsw.javausersservice.models.dto.response;


import lombok.Getter;
import lombok.Setter;

public class InstructorResponse extends Response {
    @Getter
    @Setter
    public Integer id;

    @Getter
    @Setter
    public String status;

    public InstructorResponse(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
}
