package com.barberia.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barberia.springboot.app.models.entity.BloqueHorario;

@Repository("repositoriobloquehorario")
public interface BloqueHorarioDao extends JpaRepository<BloqueHorario,Long> {
	public abstract BloqueHorario findByIdBloque(long id) ;
}
