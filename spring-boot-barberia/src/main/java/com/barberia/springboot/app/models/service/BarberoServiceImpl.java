package com.barberia.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.springboot.app.models.dao.IBarberoDao;
import com.barberia.springboot.app.models.entity.Barbero;
@Service
public class BarberoServiceImpl implements IBarberoService{
	@Autowired
	private IBarberoDao barberoDao;

	@Override
	public List<Barbero> findAll() {
		return barberoDao.findAll();
	}

	@Override
	public void save(Barbero barbero) {
		barberoDao.save(barbero);
	}

	@Override
	public Barbero findOne(Long id) {
		return barberoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		barberoDao.deleteById(id);
	}
}
