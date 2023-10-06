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

    /**
     * La función devuelve el número de piezas necesarias para un ID de modelo determinado.
     * 
     * @param idModelo El parámetro "idModelo" es un número entero que representa el ID de un modelo.
     * @return El método devuelve la cantidad de piezas necesarias para un ID de modelo determinado.
     */
    @Override
    public int piezasNecesarias(int idModelo) {
        return dao.findById(idModelo).get().getPiezasNecesarias();
    }

    /**
     * La función "modelos()" devuelve una lista de todos los objetos "Modelo" en la base de datos.
     * 
     * @return Se devuelve una lista de objetos Modelo.
     */
    @Override
    public List<Modelo> modelos() {
        return dao.findAll();
    }

    /**
     * La función actualiza el número de piezas necesarias para un modelo determinado.
     * 
     * @param idModelo La identificación del modelo para el cual desea actualizar la cantidad de piezas
     * necesarias.
     * @param piezasNecesarias El parámetro "piezasNecesarias" representa el número de piezas
     * necesarias para un modelo en particular.
     */
    @Override
    public void actualizarPiezasNecesarias(int idModelo, int piezasNecesarias) {
        Modelo modelo = dao.findById(idModelo).get();
        modelo.setPiezasNecesarias(piezasNecesarias);
        dao.save(modelo);
    }

    @Override
    public void eliminar(int idModelo) {
        dao.deleteById(idModelo);
    }

    /**
     * La función `nuevoModelo` guarda un nuevo objeto `Modelo` usando el objeto `dao`.
     * 
     * @param modelo El parámetro "modelo" es un objeto de tipo "Modelo".
     */
    @Override
    public void nuevoModelo(Modelo modelo) {
        dao.save(modelo);
    }

    /**
     * La función actualiza el nombre de un modelo en una base de datos en función de su ID.
     * 
     * @param idModelo La identificación del modelo que necesita ser actualizado.
     * @param nombreModelo El parámetro "nombreModelo" es un String que representa el nuevo nombre de
     * un modelo.
     */
    @Override
    public void actualizarNombreModelo(int idModelo, String nombreModelo) {
        Modelo modelo = dao.findById(idModelo).get();
        modelo.setNombreModelo(nombreModelo);
        dao.save(modelo);
    }

    /**
     * La función actualiza el costo de un modelo con el ID dado.
     * 
     * @param idModelo La identificación del modelo que necesita ser actualizado.
     * @param coste El parámetro "coste" es un valor doble que representa el costo actualizado de un
     * modelo.
     */
    @Override
    public void actualizarCoste(int idModelo, double coste) {
        Modelo modelo = dao.findById(idModelo).get();
        modelo.setCoste(coste);
        dao.save(modelo);
    }

    /**
     * La función devuelve el costo de un modelo dado su ID.
     * 
     * @param idModelo El parámetro "idModelo" es un número entero que representa el identificador
     * único de un modelo.
     * @return El método devuelve el costo de un modelo con la identificación dada.
     */
    @Override
    public double costeModelo(int idModelo) {
        return dao.findById(idModelo).get().getCoste();
    }

    @Override
    public List<Modelo> filtroCoste(double costeMinimo, double costeMaximo) {
        return dao.filtrarPorCosteMonetario(costeMinimo, costeMaximo);
    }

    @Override
    public List<Modelo> filtroPiezas(int piezasMinimo, int piezasMaximo) {
        return dao.filtrarPorCostePiezas(piezasMinimo, piezasMaximo);
    }

    @Override
    public List<Modelo> filtroNombre(String filtro) {
        return dao.filtrarPorNombre(filtro);
    }
}
