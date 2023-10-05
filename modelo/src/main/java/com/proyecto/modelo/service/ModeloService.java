package com.proyecto.modelo.service;

import java.util.List;

import com.proyecto.modelo.model.Modelo;

public interface ModeloService {
    List<Modelo> modelos();
    int piezasNecesarias(int idModelo);
    void actualizarPiezasNecesarias(int idModelo, int piezasNecesarias);
    void eliminar (int idModelo);
    void nuevoModelo (Modelo modelo);
}
