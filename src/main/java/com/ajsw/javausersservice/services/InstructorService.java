package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Instructor;
import com.ajsw.javausersservice.repositories.interfaces.IInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final IInstructorRepository instructorRepository;


    @Autowired
    public InstructorService(IInstructorRepository iInstructorRepository){
        instructorRepository = iInstructorRepository;
    }

    public Response saveInstructor(Instructor instructor){
        instructorRepository.save(instructor);
        return new Response();
    }

    public Instructor getInstructorById(Long id){
        return instructorRepository.findById(id).get();
    }

    public List<Instructor> getInstructors(){
        return instructorRepository.findAll();
    }
}
