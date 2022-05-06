package com.ajsw.javausersservice.controllers;
import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Instructor;
import com.ajsw.javausersservice.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService _instructorService){
        instructorService = _instructorService;
    }

    @PostMapping()
    public Response createInstructor(@Validated @RequestBody InstructorRequest instructorRequest){
        try{

            return instructorService.saveInstructor(new Instructor());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al dar de alta el instructor.\n");
        }
    }

    @GetMapping()
    public List<Instructor> getInstructors(){
        return instructorService.getInstructors();
    }
}
