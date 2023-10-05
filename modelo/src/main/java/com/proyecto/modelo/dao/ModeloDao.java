package com.proyecto.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.modelo.model.Modelo;

public interface ModeloDao extends JpaRepository <Modelo, Integer> {
    
}
