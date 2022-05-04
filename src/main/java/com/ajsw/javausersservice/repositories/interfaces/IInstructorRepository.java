package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
}
