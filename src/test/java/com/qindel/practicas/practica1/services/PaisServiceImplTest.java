package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.PaisDto;
import com.qindel.practicas.practica1.entities.PaisEntity;
import com.qindel.practicas.practica1.mapper.IPaisMapper;
import com.qindel.practicas.practica1.repositories.IPaisRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;

public class PaisServiceImplTest {
    @Mock
    private IPaisRepository paisRepository;

    @InjectMocks
    private IPaisService paisService;

    @Mock
    private IPaisMapper paisMapper;


    @ParameterizedTest
    @CsvSource({"2,Portugal,pt,200", "3,Francia,fr,50"})
    public void getPaisByIdTest(String id_paisString, String nombre_pais, String codigo_pais, String valor_paisString) {
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
    @CsvSource({"5,Brasil,br,300"})
    public PaisDto updatePais(PaisDto paisDto, Integer idPais) {
        PaisEntity newPais = paisMapper.toEntity(paisDto);
        return paisMapper.toDto(paisRepository.findById(idPais)
                .map(pais -> {
                    pais.setCodigopais(newPais.getCodigopais());
                    pais.setIdpais(newPais.getIdpais());
                    pais.setNombrepais(newPais.getNombrepais());
                    pais.setValorpais(newPais.getValorpais());
                    return paisRepository.save(pais);
                }).orElseGet(() -> {
                    newPais.setIdpais(idPais);
                    return paisRepository.save(newPais);
                })
        );
    }

}
