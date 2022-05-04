package com.ajsw.javausersservice.controllers;
import com.ajsw.javausersservice.mapper.InstructorMapper;
import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.InstructorResponse;
import com.ajsw.javausersservice.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    private final InstructorService instructorService;
    private final InstructorMapper instructorMapper;

    @Autowired
    public InstructorController(InstructorService _instructorService, InstructorMapper _instructorMapper){
        instructorService = _instructorService;
        instructorMapper = _instructorMapper;
    }

    @PostMapping()
    public InstructorResponse createInstructor(@Validated @RequestBody InstructorRequest instructorRequest){
        return instructorService.saveInstructor(instructorMapper.mapAccountRequestToAccount(instructorRequest));
    }
}
