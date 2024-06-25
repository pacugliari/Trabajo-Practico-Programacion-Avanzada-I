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
import com.TPPAI.dto.DomicilioDTO;
import com.TPPAI.service.DomicilioService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/domicilio")
public class DomicilioController {
	
	@Autowired
	private DomicilioService domicilioService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(required = true) Long id) {
		try {
			DomicilioDTO d = domicilioService.getById(id);
			return new ResponseEntity<DomicilioDTO>(d,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		List<DomicilioDTO> domicilios = domicilioService.getAll();
		return new ResponseEntity<List<DomicilioDTO>>(domicilios,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(required = true) Long id){
		try {
			domicilioService.delete(id);
			return new ResponseEntity<String>("Domicilio borrado con exito",HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody DomicilioDTO dto,@PathVariable(required = true) Long id){
		try {
			return new ResponseEntity<DomicilioDTO>(domicilioService.update(dto,id),HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
		
	}
	
}
