package com.barberia.springboot.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.barberia.springboot.app.models.entity.Barbero;

public interface IBarberoDao extends JpaRepository<Barbero, Long> {

}
