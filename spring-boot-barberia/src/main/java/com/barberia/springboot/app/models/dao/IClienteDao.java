package com.barberia.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberia.springboot.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
}
