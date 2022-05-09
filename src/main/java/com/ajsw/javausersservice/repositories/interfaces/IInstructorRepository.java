package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor, Integer> {
}

