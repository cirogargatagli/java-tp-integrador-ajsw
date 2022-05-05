package com.ajsw.javausersservice.controllers;
import com.ajsw.javausersservice.mapper.InstructorMapper;
import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.InstructorResponse;
import com.ajsw.javausersservice.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        try{
            return instructorService.saveInstructor(instructorMapper.mapAccountRequestToAccount(instructorRequest));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al dar de alta el instructor.\n");
        }
    }
}