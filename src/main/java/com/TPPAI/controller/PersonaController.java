package com.TPPAI.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TPPAI.dto.PersonaDTO;
import com.TPPAI.service.PersonaService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(required = true) Long id) {
		try {
			PersonaDTO p = personaService.getById(id);
			return new ResponseEntity<PersonaDTO>(p,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		List<PersonaDTO> personas = personaService.getAll();
		return new ResponseEntity<List<PersonaDTO>>(personas,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> add(@Valid @RequestBody PersonaDTO dto){
		try {
			return new ResponseEntity<PersonaDTO>(personaService.add(dto),HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(required = true) Long id){
		try {
			personaService.delete(id);
			return new ResponseEntity<String>("Persona borrada con exito",HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody PersonaDTO dto,@PathVariable(required = true) Long id){
		try {
			return new ResponseEntity<PersonaDTO>(personaService.update(dto,id),HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
}
