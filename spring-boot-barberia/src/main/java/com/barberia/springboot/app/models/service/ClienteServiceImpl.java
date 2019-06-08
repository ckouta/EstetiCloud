package com.barberia.springboot.app.models.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.springboot.app.models.dao.IClienteDao;
import com.barberia.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private IClienteDao clienteDao;

	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	
	


}
