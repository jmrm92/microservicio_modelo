package com.proyecto.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.modelo.dao.ModeloDao;
import com.proyecto.modelo.model.Modelo;
import com.proyecto.modelo.service.ModeloServiceImpl;

@SpringBootTest
class ModeloApplicationTests {

	@Mock
	private ModeloDao dao;

	@InjectMocks
	private ModeloServiceImpl service;

	@Test
	void testPiezasNecesarias() {
		// Preparar
		int idModelo = 1;
		Modelo modelo = new Modelo();
		modelo.setPiezasNecesarias(100);

		when(dao.findById(idModelo)).thenReturn(Optional.of(modelo));

		// Ejecutar
		int result = service.piezasNecesarias(idModelo);

		// Verificar
		assertEquals(100, result);
	}

	@Test
	void testActualizarPiezasNecesarias() {
		// Preparar
		int idModelo = 1;
		int nuevasPiezasNecesarias = 200;
		Modelo modelo = new Modelo();

		when(dao.findById(idModelo)).thenReturn(Optional.of(modelo));

		// Ejecutar
		service.actualizarPiezasNecesarias(idModelo, nuevasPiezasNecesarias);

		// Verificar
		assertEquals(nuevasPiezasNecesarias, modelo.getPiezasNecesarias());
		verify(dao).save(modelo);
	}

	@Test
	void testActualizarNombreModelo() {
		// Preparar
		int idModelo = 1;
		String nuevoNombre = "NuevoNombre";
		Modelo modelo = new Modelo();

		when(dao.findById(idModelo)).thenReturn(Optional.of(modelo));

		// Ejecutar
		service.actualizarNombreModelo(idModelo, nuevoNombre);

		// Verificar
		assertEquals(nuevoNombre, modelo.getNombreModelo());
		verify(dao).save(modelo);
	}

}
