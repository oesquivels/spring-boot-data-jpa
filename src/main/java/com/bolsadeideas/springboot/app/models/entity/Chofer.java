package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "choferes")
public class Chofer implements Serializable {

//	private Long id;
//	private String nombre;
//	private String apePaterno;
//	private String apeMaterno;
//	private Long docIdentidad;
//	private String direccion;
//	private Long nroCelular;
//	private Long nroTelefono;
//	private String email;
//	private Date fechaInicio;
//	private Date fechaFin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	@Column(name = "ape_paterno")
	private String apePaterno;

	@NotEmpty
	@Column(name = "ape_materno")
	private String apeMaterno;
	
	@NotNull
	@Column(name = "doc_identidad")
	private Long docIdentidad;
	
	@NotEmpty
	private String direccion;
	
	@NotNull
	@Column(name = "nro_celular")
	private Long nroCelular;
	
//	@NotNull
	@Column(name = "nro_telefono")
	private Long nroTelefono;

	@Email
	private String email;

	@NotNull
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicio;

	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public Long getDocIdentidad() {
		return docIdentidad;
	}

	public void setDocIdentidad(Long docIdentidad) {
		this.docIdentidad = docIdentidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getNroCelular() {
		return nroCelular;
	}

	public void setNroCelular(Long nroCelular) {
		this.nroCelular = nroCelular;
	}

	public Long getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(Long nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * 
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private static final long serialVersionUID = 1L;

}
