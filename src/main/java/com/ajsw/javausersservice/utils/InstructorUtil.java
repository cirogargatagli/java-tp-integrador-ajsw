package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Instructor;
import org.springframework.stereotype.Component;

@Component
public class InstructorUtil extends PersonUtil{

    public Instructor createInstructor(InstructorRequest instructorRequest){
        return new Instructor(
                instructorRequest.getFirstName(),
                instructorRequest.getLastName(),
                instructorRequest.getPhone(),
                new Account(instructorRequest.getIdAccount())
        );
    }

}
