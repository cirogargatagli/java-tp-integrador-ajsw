package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.InstructorResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Instructor;
import com.ajsw.javausersservice.models.mappers.ListMapper;
import com.ajsw.javausersservice.repositories.interfaces.IInstructorRepository;
import com.ajsw.javausersservice.utils.InstructorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final IInstructorRepository instructorRepository;
    private final InstructorUtil instructorUtil;
    private final ModelMapper modelMapper;
    private final ListMapper listMapper;
    private final String nameEntity = "Instructor";


    @Autowired
    public InstructorService(IInstructorRepository iInstructorRepository, InstructorUtil instructorUtil, ModelMapper modelMapper, ListMapper listMapper){
        instructorRepository = iInstructorRepository;
        this.instructorUtil = instructorUtil;
        this.modelMapper = modelMapper;
        this.listMapper = listMapper;
    }

    public Response saveInstructor(InstructorRequest instructor){
        Instructor newInstructor = instructorRepository.save(instructorUtil.createInstructor(instructor));
        return new EntityCreatedResponse(newInstructor.getIdPerson(), nameEntity);
    }

    public InstructorResponseDto getInstructorById(int id){
        return modelMapper.map(instructorRepository.findById(id).get(), InstructorResponseDto.class);
    }

    public List<InstructorResponseDto> getInstructors(){
        return listMapper.mapList(instructorRepository.findAll(), InstructorResponseDto.class);
    }
}
