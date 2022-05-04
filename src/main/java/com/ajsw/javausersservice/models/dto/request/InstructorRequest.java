package com.ajsw.javausersservice.models.dto.request;

import lombok.Getter;
import lombok.Setter;

public class InstructorRequest {
    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private Long id_course;
}