package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.mapper.InstructorMapper;
import com.ajsw.javausersservice.models.dto.response.InstructorResponse;
import com.ajsw.javausersservice.models.entity.Instructor;
import com.ajsw.javausersservice.repositories.interfaces.IInstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    private final IInstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;


    @Autowired
    public InstructorService(IInstructorRepository iInstructorRepository, InstructorMapper _instructorMapper){
        instructorRepository = iInstructorRepository;
        instructorMapper = _instructorMapper;
    }

    public InstructorResponse saveInstructor(Instructor instructor){

        return instructorMapper.mapInstructorToInstructorResponse(instructorRepository.save(instructor));
    }

    public Instructor getInstructorById(Long id){
        return instructorRepository.findById(id).get();
    }
}
