package com.barberia.springboot.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.barberia.springboot.app.models.dao.BloqueHorarioDao;
import com.barberia.springboot.app.models.entity.BloqueHorario;


@Service("serviciobloquehorario")
public class ServicioBloqueHorario {
	
	@Autowired
	@Qualifier("repositoriobloquehorario")
	private BloqueHorarioDao repositorio ;
	
	public boolean insertarBloque(BloqueHorario bloque) {
		try {
			repositorio.save(bloque);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}
	
	public boolean eliminarBloque(long id) {
		try {
			BloqueHorario bloque = repositorio.findByIdBloque(id);
			repositorio.delete(bloque);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}
	
	public boolean modificarBloque(BloqueHorario bloque) {
		try {
			BloqueHorario bloqueAux = repositorio.findByIdBloque(bloque.getIdBloque());
			if(bloqueAux == null) {
				return false ;
			}
			repositorio.save(bloque);
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}
	
}
