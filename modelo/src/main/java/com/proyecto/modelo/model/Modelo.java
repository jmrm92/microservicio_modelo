package com.proyecto.modelo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Modelo {
    
    @Id
    @Column (name ="id_modelo")
    private int idModelo;
    @Column (name ="nombre_modelo")
    private String nombreModelo;
    @Column (name ="piezas_necesarias")
    private int piezasNecesarias;
    
    public Modelo() {
    }

    public Modelo(int idModelo, String nombreModelo, int piezasNecesarias) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.piezasNecesarias = piezasNecesarias;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public int getPiezasNecesarias() {
        return piezasNecesarias;
    }

    public void setPiezasNecesarias(int piezasNecesarias) {
        this.piezasNecesarias = piezasNecesarias;
    }
}
