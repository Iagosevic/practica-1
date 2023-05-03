package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.impl.CiudadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CiudadServiceImplTest {
    @Mock
    private ICiudadRepository ciudadRepository;

    @InjectMocks
    private CiudadServiceImpl ciudadService;

    @Mock
    private ICiudadMapper ciudadMapper;


    @Test
    public void getAllCiudadesTest() {

        List<CiudadEntity> ciudadesEntity = new ArrayList<>();
        CiudadEntity ciudadEntity = new CiudadEntity();
        ciudadEntity.setIdciudad(1);
        ciudadEntity.setNombreciudad("Lima");
        ciudadesEntity.add(ciudadEntity);

        List<CiudadDto> ciudadesDto = new ArrayList<>();
        CiudadDto ciudadDto = new CiudadDto();
        ciudadDto.setIdciudad(1);
        ciudadDto.setNombreciudad("Lima");
        ciudadesDto.add(ciudadDto);

        when(ciudadRepository.findAll()).thenReturn(ciudadesEntity);
        when(ciudadMapper.toDto(ciudadEntity)).thenReturn(ciudadDto);

        List<CiudadDto> result = ciudadService.getAllCiudades();

        assertEquals(ciudadesDto, result);
        verify(ciudadRepository, times(1)).findAll();
        verify(ciudadMapper, times(1)).toDto(ciudadEntity);
    }

    @ParameterizedTest
    @CsvSource({"1,A Corunha,1,93", "8,Paris,3,5"})
    public void getCiudadByIdTest(String id_ciudadString, String nombre_ciudad, String id_paisString, String valor_ciudadString) {
        Integer id_ciudad = Integer.parseInt(id_ciudadString);
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_ciudad = Integer.parseInt(valor_ciudadString);

        CiudadEntity ciudad = new CiudadEntity(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);

        when(ciudadRepository.getReferenceById(id_ciudad)).thenReturn(ciudad);

        CiudadDto ciudadDto = new CiudadDto(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        when(ciudadMapper.toDto(ciudad)).thenReturn(ciudadDto);

        CiudadDto ciudadDtoExpected = ciudadService.getCiudadByIdCiudad(id_ciudad);

        Mockito.verify(ciudadRepository, times(1)).getReferenceById(id_ciudad);
        assertThat(ciudadDto).usingRecursiveComparison().isEqualTo(ciudadDtoExpected);

    }

    @ParameterizedTest
    @CsvSource({"1,A Corunha,1,93", "8,Paris,3,5"})
    public void addCiudadTest(String id_ciudadString, String nombre_ciudad, String id_paisString, String valor_ciudadString) {
        Integer id_ciudad = Integer.parseInt(id_ciudadString);
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_ciudad = Integer.parseInt(valor_ciudadString);

        CiudadEntity ciudad = new CiudadEntity(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        when(ciudadRepository.save(ciudad)).thenReturn(ciudad);

        CiudadDto ciudadDto = new CiudadDto(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        when(ciudadMapper.toDto(ciudad)).thenReturn(ciudadDto);
        when(ciudadMapper.toEntity(ciudadDto)).thenReturn(ciudad);

        CiudadDto ciudadDtoExpected = ciudadService.addCiudad(ciudadDto);
        Mockito.verify(ciudadRepository, times(1)).save(ciudad);
        assertThat(ciudadDto).usingRecursiveComparison().isEqualTo(ciudadDtoExpected);
    }

    @ParameterizedTest
    @CsvSource({"14,Elche,1,309"})
    public void updateCiudad(String id_ciudadString, String nombre_ciudad, String id_paisString, String valor_ciudadString) {

        Integer id_ciudad = Integer.parseInt(id_ciudadString);
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_ciudad = Integer.parseInt(valor_ciudadString);

        CiudadEntity ciudadEntity = new CiudadEntity(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        when(ciudadRepository.save(ciudadEntity)).thenReturn(ciudadEntity);

        CiudadDto ciudadDto = new CiudadDto(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        when(ciudadMapper.toDto(ciudadEntity)).thenReturn(ciudadDto);
        when(ciudadMapper.toEntity(ciudadDto)).thenReturn(ciudadEntity);

        Mockito.when(ciudadRepository.findById(1)).thenReturn(Optional.of(ciudadEntity));
        Mockito.when(ciudadRepository.save(Mockito.any(CiudadEntity.class))).thenReturn(ciudadEntity);

        CiudadDto updatedCiudad = ciudadService.updateCiudad(ciudadDto, 1);


        assertEquals(ciudadDto.getIdciudad(), updatedCiudad.getIdciudad());
        assertEquals(ciudadDto.getIdpais(), updatedCiudad.getIdpais());
        assertEquals(ciudadDto.getNombreciudad(), updatedCiudad.getNombreciudad());
        assertEquals(ciudadDto.getValorciudad(), updatedCiudad.getValorciudad());
    }

    @ParameterizedTest
    @CsvSource({"4,Lisboa,2,135", "10,Milan,4,136", "12,Turin,4,191"})
    public void updateCiudadNotFoundTest(String id_ciudadString, String nombre_ciudad, String id_paisString, String nuevoValor_ciudadString) throws Exception {
        Integer id_ciudad = Integer.parseInt(id_ciudadString);
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer nuevoValor_ciudad = Integer.parseInt(nuevoValor_ciudadString);

        CiudadEntity ciudadNew = new CiudadEntity(id_ciudad,nombre_ciudad,id_pais,nuevoValor_ciudad);

        CiudadDto ciudadDto = new CiudadDto(id_ciudad,nombre_ciudad,id_pais,nuevoValor_ciudad);

        when(ciudadRepository.findById(id_ciudad)).thenReturn(Optional.empty());
        when(ciudadRepository.save(ciudadNew)).thenReturn(ciudadNew);
        when(ciudadMapper.toEntity(ciudadDto)).thenReturn(ciudadNew);
        when(ciudadMapper.toDto(ciudadNew)).thenReturn(ciudadDto);
        CiudadDto ciudadDtoNewExpected = ciudadService.updateCiudad(ciudadDto, id_ciudad);

        Mockito.verify(ciudadRepository, times(1)).findById(id_ciudad);
        Mockito.verify(ciudadRepository, times(1)).save(ciudadNew);
        assertThat(ciudadDto).isEqualTo(ciudadDtoNewExpected);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 10, 12, Integer.MAX_VALUE})
    public void deleteCiudadTest(int id) throws Exception {
        ciudadService.deleteCiudad(id);
        Mockito.verify(ciudadRepository).deleteById(id);
    }
}

