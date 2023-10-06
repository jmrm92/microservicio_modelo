package com.proyecto.modelo;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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
    public void testActualizarPiezasNecesarias() {
        // Paso 1
        Modelo modelo = new Modelo();
        modelo.setPiezasNecesarias(10);

        when(dao.findById(1)).thenReturn(Optional.of(modelo));

        service.actualizarPiezasNecesarias(1, 20);

        verify(dao).findById(1);
        verify(dao).save(argThat(updatedModelo -> updatedModelo.getPiezasNecesarias() == 20));

        verifyNoMoreInteractions(dao);
    }

}
