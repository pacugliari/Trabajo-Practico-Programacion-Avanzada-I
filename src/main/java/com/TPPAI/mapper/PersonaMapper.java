package com.TPPAI.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TPPAI.dto.PersonaDTO;
import com.TPPAI.entity.Persona;

@Component
public class PersonaMapper {
	
	@Autowired
	private DomicilioMapper domicilioMapper;
	
	public PersonaDTO entityToDto (Persona entity) {
		
		PersonaDTO dto = new PersonaDTO();
		dto.setId(entity.getId());
		dto.setFechaNacimiento(entity.getFechaNac());
		dto.setNombre(entity.getNombre());
		dto.setDomicilios(domicilioMapper.entitiesToDtos(entity.getDomicilios()));
		return dto;
	}
	
	public Persona DtoToEntity (PersonaDTO dto) {
		
		Persona persona = new Persona();
		persona.setId(dto.getId());
		return persona;
	}
	
	public List<PersonaDTO> entitiesToDtos (List<Persona> entities) {
		List<PersonaDTO> dtos = new ArrayList<>();
		
		for (Persona p : entities) {
			dtos.add(this.entityToDto(p));
		}
		
		return dtos;
		
	}
	
	


}
