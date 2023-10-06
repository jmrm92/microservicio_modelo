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

    /**
     * La función anterior es una asignación de solicitud GET que devuelve una lista de objetos del
     * modelo en formato JSON.
     * 
     * @return Se devuelve una lista de objetos Modelo.
     */
    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modelo> obtenerModelos() {
        return servicio.modelos();
    }

    /**
     * Esta función Java maneja una solicitud POST para crear un nuevo objeto "Modelo" consumiendo
     * datos JSON.
     * 
     * @param modelo El parámetro "modelo" es de tipo "Modelo" y está anotado con "@RequestBody". Esto
     * significa que el parámetro se completará con los datos JSON del cuerpo de la solicitud. Los
     * datos JSON se deserializarán en una instancia de la clase "Modelo".
     */
    @PostMapping (value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevoModelo(@RequestBody Modelo modelo) {
        servicio.nuevoModelo(modelo);
    }

    /**
     * La función "piezasNecesarias" devuelve el número de piezas necesarias para un ID de modelo
     * determinado.
     * 
     * @param idModelo El parámetro idModelo es un número entero que representa el ID de un modelo.
     * @return El método devuelve un valor entero.
     */
    @GetMapping (value = "/piezas/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int piezasNecesarias(@PathVariable("idModelo") int idModelo) {
        return servicio.piezasNecesarias(idModelo);
    }

    /**
     * La función "costeModelo" devuelve el coste de un modelo en función de su ID.
     * 
     * @param idModelo El parámetro idModelo es un número entero que representa el ID de un modelo.
     * @return El método devuelve un valor doble, que representa el costo de un modelo.
     */
    @GetMapping (value = "/coste/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double costeModelo(@PathVariable("idModelo") int idModelo) {
        return servicio.costeModelo(idModelo);
    }

    /**
     * La función "filtroPiezas" toma dos parámetros enteros, "piezasMinimo" y "piezasMaximo", y
     * devuelve una lista de objetos "Modelo".
     * 
     * @param piezasMinimo El número mínimo de piezas (pieces) para el filtro (filtro).
     * @param piezasMaximo El número máximo de piezas.
     * @return El método devuelve una lista de objetos del modelo.
     */
    @GetMapping (value = "/filtro-piezas/{piezasMinimo}/{piezasMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modelo> filtroPiezas(@PathVariable("piezasMinimo") int piezasMinimo, @PathVariable("piezasMaximo") int piezasMaximo) {
        return servicio.filtroPiezas(piezasMinimo, piezasMaximo);
    }

    /**
     * La función filtra una lista de modelos en función de un costo mínimo y máximo.
     * 
     * @param costeMinimo El valor de costo mínimo para filtrar los modelos.
     * @param costeMaximo El parámetro costeMaximo representa el valor de costo máximo para filtrar la
     * lista de Modelos.
     * @return El método devuelve una Lista de objetos de tipo Modelo.
     */
    @GetMapping (value = "/filtro-coste/{costeMinimo}/{costeMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modelo> filtrarPorCoste(@PathVariable("costeMinimo") double costeMinimo, @PathVariable("costeMaximo") double costeMaximo) {
        return servicio.filtroCoste(costeMinimo, costeMaximo);
    }

    /**
     * La función "filtroNombre" en una clase de controlador Java devuelve una lista de objetos
     * "Modelo" basados en un parámetro "filtro" dado.
     * 
     * @param filtro El parámetro "filtro" es una variable de cadena que representa el valor del filtro
     * utilizado para buscar modelos.
     * @return El método devuelve una lista de objetos Modelo.
     */
    @GetMapping (value = "filtro-nombre/{filtro}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Modelo> filtroNombre(@PathVariable("filtro") String filtro) {
        return servicio.filtroNombre(filtro);
    }

    /**
     * La función actualiza el número de piezas necesarias para un modelo determinado.
     * 
     * @param idModelo La identificación del modelo para el cual se están actualizando las piezas
     * necesarias. Es de tipo int.
     * @param piezasNecesarias El parámetro "piezasNecesarias" representa el número de piezas
     * necesarias para un modelo específico.
     */
    @PutMapping (value = "/actualizar-piezas-necesarias/{idModelo}/{piezasNecesarias}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarPiezasNecesarias(@PathVariable("idModelo") int idModelo, @PathVariable("piezasNecesarias") int piezasNecesarias) {
        servicio.actualizarPiezasNecesarias(idModelo, piezasNecesarias);
    }

    /**
     * La función actualiza el nombre de un modelo según la ID del modelo proporcionada.
     * 
     * @param idModelo La identificación del modelo que necesita ser actualizado.
     * @param nombreModelo El parámetro "nombreModelo" es un String que representa el nuevo nombre de
     * un modelo.
     */
    @PutMapping (value = "/actualizar-nombre-modelo/{idModelo}/{nombreModelo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarNombreModelo(@PathVariable("idModelo") int idModelo, @PathVariable("nombreModelo") String nombreModelo) {
        servicio.actualizarNombreModelo(idModelo, nombreModelo);
    }

    /**
     * La función actualiza el costo de un modelo según su ID.
     * 
     * @param idModelo La identificación del modelo que necesita ser actualizado.
     * @param coste El parámetro "costo" es de tipo doble y representa el valor de costo actualizado
     * para un modelo específico.
     */
    @PutMapping (value = "/actualizar-coste/{idModelo}/{coste}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarCoste(@PathVariable("idModelo") int idModelo, @PathVariable("coste") double coste) {
        servicio.actualizarCoste(idModelo, coste);
    }

    // La anotación `@DeleteMapping` se utiliza para manejar solicitudes DELETE HTTP. En este caso, la
    // anotación `@DeleteMapping` se aplica al método `eliminar`, que toma un parámetro `idModelo`
    // anotado con `@PathVariable`.
    @DeleteMapping (value = "/{idModelo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable("idModelo") int idModelo) {
        servicio.eliminar(idModelo);
    }
}
