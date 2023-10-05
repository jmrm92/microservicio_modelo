package com.proyecto.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.dao.ModeloDao;
import com.proyecto.modelo.model.Modelo;

@Service
public class ModeloServiceImpl implements ModeloService{

    @Autowired
    ModeloDao dao;

    @Override
    public int piezasNecesarias(int idModelo) {
        return dao.findById(idModelo).get().getPiezasNecesarias();
    }

    @Override
    public List<Modelo> modelos() {
        return dao.findAll();
    }

    @Override
    public void actualizarPiezasNecesarias(int idModelo, int piezasNecesarias) {
        dao.findById(idModelo).get().setPiezasNecesarias(piezasNecesarias);
    }

    @Override
    public void eliminar(int idModelo) {
        dao.deleteById(idModelo);
    }

    @Override
    public void nuevoModelo(Modelo modelo) {
        dao.save(modelo);
    }
}
