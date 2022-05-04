package com.ajsw.javausersservice.mapper;

import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.InstructorResponse;
import com.ajsw.javausersservice.models.entity.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {
    public Instructor mapAccountRequestToAccount(InstructorRequest instructorRequest){
        return new Instructor();
    }

    public InstructorResponse mapInstructorToInstructorResponse(Instructor instructor){
        return new InstructorResponse(instructor.getIdPerson(), "Created");
    }
}
