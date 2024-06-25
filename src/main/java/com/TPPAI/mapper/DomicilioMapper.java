package com.TPPAI.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.TPPAI.dto.DomicilioDTO;
import com.TPPAI.entity.Domicilio;

@Component
public class DomicilioMapper {
	
	public DomicilioDTO entityToDto (Domicilio entity) {
		
		DomicilioDTO dto = new DomicilioDTO();
		dto.setCalle(entity.getCalle());
		dto.setId(entity.getId());
		dto.setNro(entity.getNro());
		
		return dto;
	}
	
	public Domicilio DtoToEntity (DomicilioDTO dto) {
		
		Domicilio domicilio = new Domicilio();
		domicilio.setId(dto.getId());
		domicilio.setCalle(dto.getCalle());
		domicilio.setNro(dto.getNro());

		return domicilio;
	}
	
	public List<DomicilioDTO> entitiesToDtos (List<Domicilio> entities) {
		List<DomicilioDTO> dtos = new ArrayList<>();
		
		for (Domicilio d : entities) {
			dtos.add(this.entityToDto(d));
		}
		
		return dtos;
		
	}
	
	


}
