package com.TPPAI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "sys_domicilio")
public class Domicilio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dom_id")
	private Long id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="nro")
	private Integer nro;
	
	@ManyToOne
	@JoinColumn(name="per_id") //GENERALMENTE VA EN EL LADO DONDE VA LA RELACION SOLA, EL NOMBRE ES LA COLUMNA DE FK
	private Persona persona;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}


}
