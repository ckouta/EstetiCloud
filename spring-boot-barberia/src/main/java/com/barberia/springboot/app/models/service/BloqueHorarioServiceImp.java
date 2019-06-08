package com.barberia.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.springboot.app.models.dao.BloqueHorarioDao;
import com.barberia.springboot.app.models.entity.BloqueHorario;

@Service
public class BloqueHorarioServiceImp implements IBloqueHorarioService {
	@Autowired
	BloqueHorarioDao bloquehorario ;

	@Override
	public List<BloqueHorario> findAll() {
		return bloquehorario.findAll();
	}

	@Override
	public void save(BloqueHorario bloque) {
		bloquehorario.save(bloque);
	}

	@Override
	public BloqueHorario findOne(Long id) {
		return bloquehorario.findByIdBloque(id);
	}

	@Override
	public void delete(Long id) {
		bloquehorario.deleteById(id);
	}
}
