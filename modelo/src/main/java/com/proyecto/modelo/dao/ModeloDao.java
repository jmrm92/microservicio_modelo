package com.proyecto.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.modelo.model.Modelo;

public interface ModeloDao extends JpaRepository<Modelo, Integer> {

    @Query("SELECT m FROM Modelo f WHERE m.nombreModelo LIKE '%:filtro%'")
    List<Modelo> filtrarPorNombre(@Param("filtro") String filtro);

    @Query("SELECT m FROM Modelo m WHERE m.costeMonetario BETWEEN :costeMinimo AND :costeMaximo")
    List<Modelo> filtrarPorCosteMonetario(@Param("costeMinimo") double costeMinimo,
            @Param("costeMaximo") double costeMaximo);

    @Query("SELECT m FROM Modelo m WHERE m.piezasNecesarias BETWEEN :piezasMinimo AND :piezasMaximo")
    List<Modelo> filtrarPorCostePiezas(@Param("piezasMinimo") int piezasMinimo,
            @Param("piezasMaximo") int piezasMaximo);
}
