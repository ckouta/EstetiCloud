package com.barberia.springboot.app.models.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.barberia.springboot.app.models.entity.Servicio;

public interface IServicioDao extends JpaRepository<Servicio, Long> {

}
