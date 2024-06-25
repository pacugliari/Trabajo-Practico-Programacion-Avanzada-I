package com.TPPAI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TPPAI.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

}
