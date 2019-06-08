package com.barberia.springboot.app.models.service;

import java.util.List;

import com.barberia.springboot.app.models.entity.Barbero;

public interface IBarberoService {

	List<Barbero> findAll();

	void save(Barbero barbero);

	Barbero findOne(Long id);

	void delete(Long id);
	

}
