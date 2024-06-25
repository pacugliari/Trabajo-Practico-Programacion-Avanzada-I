package com.TPPAI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TPPAI.dto.DomicilioDTO;
import com.TPPAI.dto.PersonaDTO;
import com.TPPAI.entity.Domicilio;
import com.TPPAI.entity.Persona;
import com.TPPAI.mapper.DomicilioMapper;
import com.TPPAI.mapper.PersonaMapper;
import com.TPPAI.repository.DomicilioRepository;
import com.TPPAI.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonaService {
	//NO DEBE HABER ATRIBUTOS PROPIOS
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	DomicilioRepository domicilioRepository;
	
	@Autowired
	PersonaMapper personaMapper;
	
	@Autowired
	DomicilioMapper domicilioMapper;
	
	@Transactional
    public PersonaDTO add(PersonaDTO per) throws Exception {
        try {
            Persona p = new Persona();
            p.setNombre(per.getNombre());
            p.setFechaNac(per.getFechaNacimiento());

            List<Domicilio> domicilios = new ArrayList<>();
            for (DomicilioDTO domDTO : per.getDomicilios()) {
                Domicilio dom = domicilioMapper.DtoToEntity(domDTO);
                dom.setPersona(p);
                domicilios.add(dom);
            }

            p.setDomicilios(domicilios);

            p = this.personaRepository.save(p);

            System.out.println("Persona creada con ID: " + p.getId());
            
            return personaMapper.entityToDto(p);
        } catch (Exception e) {
            throw new Exception("Error al dar de alta a la persona: " + e.getMessage());
        }
    }
	
	@Transactional
    public PersonaDTO update (PersonaDTO per,Long id) throws Exception {
		Optional<Persona> personaOptional = this.personaRepository.findById(id);
		if(personaOptional.isPresent()) {
			try {
				Persona p = personaOptional.get();
				p.setFechaNac(per.getFechaNacimiento());
				p.setNombre(per.getNombre());
				
	            List<Domicilio> domicilios = new ArrayList<>();
	            for (DomicilioDTO domDTO : per.getDomicilios()) {
	                Domicilio dom = domicilioMapper.DtoToEntity(domDTO);
	                dom.setPersona(p);
	                domicilios.add(dom);
	            }

	            this.domicilioRepository.deleteAll(p.getDomicilios());
	            p.setDomicilios(domicilios);
	            
	            p = this.personaRepository.save(p);

	            System.out.println("Persona modificada con ID: " + p.getId());
	            
	            return personaMapper.entityToDto(p);
			} catch (Exception e) {
	            throw new Exception("Error al modificar a la persona: " + e.getMessage());
	        }
		}else {
			throw new Exception("No existe la persona");
		}
    }
	
	public void delete (Long id) throws Exception {
		Optional<Persona> p = this.personaRepository.findById(id);
		if(p.isPresent()) {
			this.personaRepository.delete(p.get());
		}else {
			throw new Exception("No existe la persona");
		}
	}
	
	public PersonaDTO getById (Long id) throws Exception {
		Optional<Persona> p = this.personaRepository.findById(id);
		if(p.isPresent()) {
			return personaMapper.entityToDto(p.get());
		}else {
			throw new Exception("No existe la persona");
		}
	}
	
	public List<PersonaDTO> getAll () {
		List<PersonaDTO> personasDto = new ArrayList<PersonaDTO>();
		List<Persona> personas = (List<Persona>) this.personaRepository.findAll();
		for(Persona persona : personas) {
			personasDto.add(personaMapper.entityToDto(persona));
		}
		return personasDto;
	}
}
