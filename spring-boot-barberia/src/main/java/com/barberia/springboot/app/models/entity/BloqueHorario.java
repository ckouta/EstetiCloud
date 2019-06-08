package com.barberia.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BLOQUE_HORARIO")
@Entity
public class BloqueHorario implements Serializable {

	// Declaración de Atributos
	@Id
	@Column(name="idBloque")
	private Long idBloque;
	@Column(name="horaInicio")
	private String horaInicio;
	@Column (name="horaFin")
	private String horaFin;

	// Constructores

	public BloqueHorario() {

	}

	public BloqueHorario(Long idBloque, String horaInicio, String horaFin) {
		this.idBloque = idBloque;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	// Getters N Setters

	public Long getIdBloque() {
		return idBloque;
	}

	public void setIdBloque(Long idBloque) {
		this.idBloque = idBloque;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

}
