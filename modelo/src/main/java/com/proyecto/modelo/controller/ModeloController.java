package com.proyecto.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.modelo.model.Modelo;
import com.proyecto.modelo.service.ModeloServiceImpl;

@RestController
public class ModeloController {

    @Autowired
    ModeloServiceImpl servicio;

    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modelo> obtenerModelos() {
        return servicio.modelos();
    }

    @PostMapping (value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevoModelo(@RequestBody Modelo modelo) {
        servicio.nuevoModelo(modelo);
    }

    @GetMapping (value = "/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int piezasNecesarias(@PathVariable("idModelo") int idModelo) {
        return servicio.piezasNecesarias(idModelo);
    }

    @PutMapping (value = "/{idModelo}/{piezasNecesarias}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarPiezasNecesarias(@PathVariable("idModelo") int idModelo, @PathVariable("piezasNecesarias") int piezasNecesarias) {
        servicio.actualizarPiezasNecesarias(idModelo, piezasNecesarias);
    }

    @DeleteMapping (value = "/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("idModelo") int idModelo) {
        servicio.eliminar(idModelo);
    }
}
