package com.ajsw.javausersservice.repositories.interfaces;

import com.ajsw.javausersservice.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
