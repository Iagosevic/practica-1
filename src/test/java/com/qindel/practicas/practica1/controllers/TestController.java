package com.qindel.practicas.practica1.controllers;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.impl.CiudadServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestController {
    //Metodo de prueba
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @Mock
    private ICiudadRepository ciudadRepository;
    @Mock
    private ICiudadMapper ciudadMapper;

    @Test
    public void getCiudadTest() {
        //Datos de entrada
        Integer idciudad = 1;
        String nombreciudad = "A Corunha";
        Integer idpais = 1;
        Integer valorciudad = 93;

        CiudadEntity ciudad = new CiudadEntity(idciudad, nombreciudad, idpais, valorciudad);

        Mockito.when(ciudadRepository.getReferenceById(idciudad)).thenReturn(ciudad);

        CiudadDto ciudadDto = new CiudadDto(idciudad, nombreciudad, idpais, valorciudad);
        Mockito.when(ciudadMapper.toDto(ciudad)).thenReturn(ciudadDto);

        CiudadDto ciudadDtoExpected = new CiudadDto(idciudad, nombreciudad, idpais, valorciudad);

        assertThat(ciudadDto).usingRecursiveComparison().isEqualTo(ciudadDtoExpected);
    }
}
