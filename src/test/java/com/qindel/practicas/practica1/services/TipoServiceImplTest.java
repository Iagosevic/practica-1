package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.mapper.ITipoMapper;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.impl.TipoServiceImpl;
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
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TipoServiceImplTest {
    @Mock
    private ITipoRepository tipoRepository;

    @InjectMocks
    private TipoServiceImpl tipoService;

    @Mock
    private ITipoMapper tipoMapper;

    @Test
    public void getAllTiposTest() {

        List<TipoEntity> tiposEntity = new ArrayList<>();
        TipoEntity tipoEntity = new TipoEntity();
        tipoEntity.setIdtipojjoo(1);
        tipoEntity.setDescripciontipo("Otoño");
        tiposEntity.add(tipoEntity);

        List<TipoDto> tiposDto = new ArrayList<>();
        TipoDto tipoDto = new TipoDto();
        tipoDto.setIdtipojjoo(1);
        tipoDto.setDescripciontipo("Peru");
        tiposDto.add(tipoDto);

        when(tipoRepository.findAll()).thenReturn(tiposEntity);
        when(tipoMapper.toDto(tipoEntity)).thenReturn(tipoDto);

        List<TipoDto> result = tipoService.getAllTipos();

        assertEquals(tiposDto, result);
        verify(tipoRepository, times(1)).findAll();
        verify(tipoMapper, times(1)).toDto(tipoEntity);
    }

    @ParameterizedTest
    @CsvSource({"1,Invierno", "2,Verano"})
    public void getTipoByIdTest(String id_tipoString, String descripcion_tipoString) {
        Integer id_tipo = Integer.parseInt(id_tipoString);

        TipoEntity tipo = new TipoEntity(id_tipo,descripcion_tipoString);
        Mockito.when(tipoRepository.getReferenceById(id_tipo)).thenReturn(tipo);

        TipoDto tipoDto =  new TipoDto(id_tipo,descripcion_tipoString);
        Mockito.when(tipoMapper.toDto(tipo)).thenReturn(tipoDto);

        TipoDto tipoDtoExpected = tipoService.getTipoById(id_tipo);

        Mockito.verify(tipoRepository, times(1)).getReferenceById(id_tipo);
        assertThat(tipoDto).usingRecursiveComparison().isEqualTo(tipoDtoExpected);

    }

    @ParameterizedTest
    @CsvSource({"3,Primavera", "4,Otoño"})
    public void addTipoTest(String id_tipoString, String descripcion_tipoString) {
        Integer id_tipo = Integer.parseInt(id_tipoString);

        TipoEntity tipo = new TipoEntity(id_tipo, descripcion_tipoString);
        Mockito.when(tipoRepository.save(tipo)).thenReturn(tipo);

        TipoDto tipoDto =  new TipoDto(id_tipo, descripcion_tipoString);
        Mockito.when(tipoMapper.toDto(tipo)).thenReturn(tipoDto);
        Mockito.when(tipoMapper.toEntity(tipoDto)).thenReturn(tipo);

        TipoDto tipoDtoExpected = tipoService.addTipo(tipoDto);
        Mockito.verify(tipoRepository, times(1)).save(tipo);
        assertThat(tipoDto).usingRecursiveComparison().isEqualTo(tipoDtoExpected);
    }

    @ParameterizedTest
    @CsvSource({"3,Primavera", "4,Otoño"})
    public void updateTipo(String id_tipoString, String descripcion_tipoString) {
        Integer id_tipo = Integer.parseInt(id_tipoString);

        TipoEntity tipoEntity = new TipoEntity(id_tipo, descripcion_tipoString);
        when(tipoRepository.save(tipoEntity)).thenReturn(tipoEntity);

        TipoDto tipoDto = new TipoDto(id_tipo, descripcion_tipoString);
        when(tipoMapper.toDto(tipoEntity)).thenReturn(tipoDto);
        when(tipoMapper.toEntity(tipoDto)).thenReturn(tipoEntity);

        Mockito.when(tipoRepository.findById(1)).thenReturn(Optional.of(tipoEntity));
        Mockito.when(tipoRepository.save(Mockito.any(TipoEntity.class))).thenReturn(tipoEntity);

        TipoDto updatedTipo = tipoService.updateTipo(tipoDto, 1);

        assertEquals(tipoDto.getIdtipojjoo(), updatedTipo.getIdtipojjoo());
        assertEquals(tipoDto.getIdtipojjoo(), updatedTipo.getIdtipojjoo());
    }

    @ParameterizedTest
    @CsvSource({"3,Primavera", "4,Otoño"})
    public void updateTipoNotFoundTest(String id_tipo_jjooString, String descripcion_tipoNuevo) {
        Integer id_tipo_jjoo = Integer.parseInt(id_tipo_jjooString);

        TipoEntity tipoJJOONew = new TipoEntity(id_tipo_jjoo,descripcion_tipoNuevo);
        TipoDto tipoJJOODtoNew = new TipoDto(id_tipo_jjoo,descripcion_tipoNuevo);

        Mockito.when(tipoRepository.findById(id_tipo_jjoo)).thenReturn(Optional.empty());
        Mockito.when(tipoRepository.save(tipoJJOONew)).thenReturn(tipoJJOONew);
        Mockito.when(tipoMapper.toEntity(tipoJJOODtoNew)).thenReturn(tipoJJOONew);
        Mockito.when(tipoMapper.toDto(tipoJJOONew)).thenReturn(tipoJJOODtoNew);
        TipoDto tipoJJOODtoNewExpected = tipoService.updateTipo(tipoJJOODtoNew, id_tipo_jjoo);

        Mockito.verify(tipoRepository, times(1)).findById(id_tipo_jjoo);
        Mockito.verify(tipoRepository, times(1)).save(tipoJJOONew);
        assertThat(tipoJJOODtoNew).isEqualTo(tipoJJOODtoNewExpected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, Integer.MAX_VALUE})
    public void deleteTipoTest(int id) throws Exception {
        tipoService.deleteTipo(id);
        Mockito.verify(tipoRepository).deleteById(id);
    }
}
