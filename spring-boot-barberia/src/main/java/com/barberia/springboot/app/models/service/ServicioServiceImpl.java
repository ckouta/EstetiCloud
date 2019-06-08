package com.barberia.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.springboot.app.models.dao.IServicioDao;
import com.barberia.springboot.app.models.entity.Servicio;
@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioDao servicioDao;
	
	@Override
	public List<Servicio> findAll() {
		
		return servicioDao.findAll();
	}

	@Override
	public void save(Servicio servicio) {
		servicioDao.save(servicio);
	}

	@Override
	public Servicio findOne(Long id) {
		return servicioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		servicioDao.deleteById(id);
		
	}

	@Override
	public boolean exists(Long id) {
		return servicioDao.existsById(id);
	}

}
