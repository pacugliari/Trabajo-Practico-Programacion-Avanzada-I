package com.TPPAI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TPPAI.dto.DomicilioDTO;
import com.TPPAI.entity.Domicilio;
import com.TPPAI.mapper.DomicilioMapper;
import com.TPPAI.mapper.PersonaMapper;
import com.TPPAI.repository.DomicilioRepository;

import jakarta.transaction.Transactional;

@Service
public class DomicilioService {

	@Autowired
	DomicilioRepository domicilioRepository;
	
	@Autowired
	PersonaMapper personaMapper;
	
	@Autowired
	DomicilioMapper domicilioMapper;
	
	
	@Transactional
    public DomicilioDTO update (DomicilioDTO dom,Long id) throws Exception {
		Optional<Domicilio> domicilioOptional = this.domicilioRepository.findById(id);
		if(domicilioOptional.isPresent()) {
			try {
				Domicilio d = domicilioOptional.get();
				d.setCalle(dom.getCalle());
				d.setNro(dom.getNro());
				
	            d = this.domicilioRepository.save(d);

	            System.out.println("Domicilio modificado con ID: " + d.getId());
	            
	            return domicilioMapper.entityToDto(d);
			} catch (Exception e) {
	            throw new Exception("Error al modificar el domicilio: " + e.getMessage());
	        }
		}else {
			throw new Exception("No existe el domicilio");
		}
    }
	
	public void delete (Long id) throws Exception {
		Optional<Domicilio> d = this.domicilioRepository.findById(id);
		if(d.isPresent()) {
			this.domicilioRepository.delete(d.get());
		}else {
			throw new Exception("No existe el domicilio");
		}
	}
	
	public DomicilioDTO getById (Long id) throws Exception {
		Optional<Domicilio> d = this.domicilioRepository.findById(id);
		if(d.isPresent()) {
			return domicilioMapper.entityToDto(d.get());
		}else {
			throw new Exception("No existe el domicilio");
		}
	}
	
	public List<DomicilioDTO> getAll () {
		List<DomicilioDTO> domiciliosDto = new ArrayList<DomicilioDTO>();
		List<Domicilio> domicilios = (List<Domicilio>) this.domicilioRepository.findAll();
		for(Domicilio domicilio : domicilios) {
			domiciliosDto.add(domicilioMapper.entityToDto(domicilio));
		}
		return domiciliosDto;
	}
}
