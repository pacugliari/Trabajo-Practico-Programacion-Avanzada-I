package com.TPPAI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.TPPAI.entity.Domicilio;


@Repository
public interface DomicilioRepository extends CrudRepository<Domicilio, Long> {

}
