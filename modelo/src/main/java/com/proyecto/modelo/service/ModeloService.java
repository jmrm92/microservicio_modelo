package com.proyecto.modelo.service;

import java.util.List;

import com.proyecto.modelo.model.Modelo;

public interface ModeloService {
    List<Modelo> modelos();
    int piezasNecesarias(int idModelo);
    double costeModelo (int idModelo);
    void actualizarPiezasNecesarias(int idModelo, int piezasNecesarias);
    void actualizarCoste (int idModelo, double coste);
    void actualizarNombreModelo (int idModelo, String nombreModelo);
    List<Modelo> filtroCoste(double costeMinimo, double costeMaximo);
    List<Modelo> filtroPiezas (int piezasMinimo, int piezasMaximo);
    List<Modelo> filtroNombre (String filtro);
    void eliminar (int idModelo);
    void nuevoModelo (Modelo modelo);
}
