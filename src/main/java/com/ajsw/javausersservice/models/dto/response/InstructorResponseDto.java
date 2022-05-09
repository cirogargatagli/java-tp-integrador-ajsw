package com.ajsw.javausersservice.models.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class InstructorResponseDto extends PersonResponseDto{
    @Getter
    @Setter
    public List<CourseResponseDto> courses;
}
