package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mapper.IPaisMapper;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import com.qindel.practicas.practica1.services.impl.PaisServiceImpl;
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
public class PaisServiceImplTest {
    @Mock
    private IPaisRepository paisRepository;

    @InjectMocks
    private PaisServiceImpl paisService;

    @Mock
    private IPaisMapper paisMapper;

    @Test
    public void getAllPaisesTest() {

        List<PaisEntity> paisesEntity = new ArrayList<>();
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setIdpais(1);
        paisEntity.setNombrepais("Peru");
        paisesEntity.add(paisEntity);

        List<PaisDto> paisesDto = new ArrayList<>();
        PaisDto paisDto = new PaisDto();
        paisDto.setIdpais(1);
        paisDto.setNombrepais("Peru");
        paisesDto.add(paisDto);

        when(paisRepository.findAll()).thenReturn(paisesEntity);
        when(paisMapper.toDto(paisEntity)).thenReturn(paisDto);

        List<PaisDto> result = paisService.getAllPaises();

        assertEquals(paisesDto, result);
        verify(paisRepository, times(1)).findAll();
        verify(paisMapper, times(1)).toDto(paisEntity);
    }

    @ParameterizedTest
    @CsvSource({"2,Portugal,pt,200", "3,Francia,fr,50"})
    public void getPaisByIdPaisTest(String id_paisString, String nombre_pais, String codigo_pais, String valor_paisString) {
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_pais = Integer.parseInt(valor_paisString);

        PaisEntity pais = new PaisEntity(id_pais,nombre_pais,codigo_pais,valor_pais);
        Mockito.when(paisRepository.getReferenceById(id_pais)).thenReturn(pais);

        PaisDto paisDto =  new PaisDto(id_pais,nombre_pais,codigo_pais,valor_pais);
        Mockito.when(paisMapper.toDto(pais)).thenReturn(paisDto);

        PaisDto paisDtoExpected = paisService.getPaisByIdPais(id_pais);

        Mockito.verify(paisRepository, times(1)).getReferenceById(id_pais);
        assertThat(paisDto).usingRecursiveComparison().isEqualTo(paisDtoExpected);

    }

    @ParameterizedTest
    @CsvSource({"2,Portugal,pt,200", "3,Francia,fr,50"})
    public void addPaisTest(String id_paisString, String nombre_pais, String codigo_pais, String valor_paisString) {
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_pais = Integer.parseInt(valor_paisString);

        PaisEntity pais = new PaisEntity(id_pais,nombre_pais,codigo_pais,valor_pais);
        Mockito.when(paisRepository.save(pais)).thenReturn(pais);

        PaisDto paisDto =  new PaisDto(id_pais,nombre_pais,codigo_pais,valor_pais);
        Mockito.when(paisMapper.toDto(pais)).thenReturn(paisDto);
        Mockito.when(paisMapper.toEntity(paisDto)).thenReturn(pais);

        PaisDto paisDtoExpected = paisService.addPais(paisDto);
        Mockito.verify(paisRepository, times(1)).save(pais);
        assertThat(paisDto).usingRecursiveComparison().isEqualTo(paisDtoExpected);
    }

    @ParameterizedTest
    @CsvSource({"5,Botswana,bt,900"})
    public void updatePais(String id_paisString, String nombre_pais, String codigo_pais, String valor_paisString) {

        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_pais = Integer.parseInt(valor_paisString);

        PaisEntity paisEntity = new PaisEntity(id_pais, nombre_pais, codigo_pais, valor_pais);
        when(paisRepository.save(paisEntity)).thenReturn(paisEntity);

        PaisDto paisDto = new PaisDto(id_pais, nombre_pais, codigo_pais, valor_pais);
        when(paisMapper.toDto(paisEntity)).thenReturn(paisDto);
        when(paisMapper.toEntity(paisDto)).thenReturn(paisEntity);

        Mockito.when(paisRepository.findById(1)).thenReturn(Optional.of(paisEntity));
        Mockito.when(paisRepository.save(Mockito.any(PaisEntity.class))).thenReturn(paisEntity);

        PaisDto updatedPais = paisService.updatePais(paisDto, 1);


        assertEquals(paisDto.getIdpais(), updatedPais.getIdpais());
        assertEquals(paisDto.getIdpais(), updatedPais.getIdpais());
        assertEquals(paisDto.getNombrepais(), updatedPais.getNombrepais());
        assertEquals(paisDto.getValorpais(), updatedPais.getValorpais());
    }

    @ParameterizedTest
    @CsvSource({"5,Botswana,bt,900"})
    public void updatePaisNotFoundTest(String id_paisString, String nombre_pais, String codigo_pais, String nuevoValor_paisString) throws Exception {
        Integer id_pais = Integer.parseInt(id_paisString);

        Integer nuevoValor_pais = Integer.parseInt(nuevoValor_paisString);

        PaisEntity paisNew = new PaisEntity(id_pais,nombre_pais,codigo_pais,nuevoValor_pais);

        PaisDto paisDto = new PaisDto(id_pais,nombre_pais,codigo_pais,nuevoValor_pais);

        when(paisRepository.findById(id_pais)).thenReturn(Optional.empty());
        when(paisRepository.save(paisNew)).thenReturn(paisNew);
        when(paisMapper.toEntity(paisDto)).thenReturn(paisNew);
        when(paisMapper.toDto(paisNew)).thenReturn(paisDto);
        PaisDto paisDtoNewExpected = paisService.updatePais(paisDto, id_pais);

        Mockito.verify(paisRepository, times(1)).findById(id_pais);
        Mockito.verify(paisRepository, times(1)).save(paisNew);
        assertThat(paisDto).isEqualTo(paisDtoNewExpected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, Integer.MAX_VALUE})
    public void deletePaisTest(int id) throws Exception {
        paisService.deletePais(id);
        Mockito.verify(paisRepository).deleteById(id);
    }

}
