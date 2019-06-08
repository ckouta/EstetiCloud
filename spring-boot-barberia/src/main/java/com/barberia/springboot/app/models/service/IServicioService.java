package com.barberia.springboot.app.models.service;

import java.util.List;

import com.barberia.springboot.app.models.entity.Servicio;

public interface IServicioService {

	List<Servicio> findAll();
	
	void save(Servicio servicio);
		
	Servicio findOne(Long id);

	void delete(Long id);
	
	boolean exists(Long id);
}
