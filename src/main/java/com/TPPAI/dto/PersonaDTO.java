package com.TPPAI.dto;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PersonaDTO {
	
	private Long id;
	
	@NotBlank
	@Size(min=1,max=20)
	private String nombre;
	
	private Date fechaNacimiento;
	
	private List<DomicilioDTO> domicilios;
	
	public List<DomicilioDTO> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<DomicilioDTO> domicilios) {
		this.domicilios = domicilios;
	}

	public PersonaDTO() {
	}
	
	public PersonaDTO(String nombre, Integer edad, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
