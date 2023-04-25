package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.CiudadDto;
import com.qindel.practicas.practica1.entities.CiudadEntity;
import com.qindel.practicas.practica1.mapper.ICiudadMapper;
import com.qindel.practicas.practica1.repositories.ICiudadRepository;
import com.qindel.practicas.practica1.services.impl.CiudadServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
@SpringBootTest
public class CiudadServiceImplTest {
    @Mock
    private ICiudadRepository ciudadRepository;

    @InjectMocks
    private CiudadServiceImpl ciudadService;

    @Mock
    private ICiudadMapper ciudadMapper;


    @ParameterizedTest
    @CsvSource({"1,A Corunha,1,93", "8,Paris,3,5"})
    public void getCiudadByIdTest(String id_ciudadString, String nombre_ciudad, String id_paisString, String valor_ciudadString) {
        Integer id_ciudad = Integer.parseInt(id_ciudadString);
        Integer id_pais = Integer.parseInt(id_paisString);
        Integer valor_ciudad = Integer.parseInt(valor_ciudadString);

        CiudadEntity ciudad = new CiudadEntity(id_ciudad,nombre_ciudad,id_pais,valor_ciudad);

        Mockito.when(ciudadRepository.getReferenceById(id_ciudad)).thenReturn(ciudad);

        CiudadDto ciudadDto =  new CiudadDto(id_ciudad,nombre_ciudad,id_pais,valor_ciudad);
        Mockito.when(ciudadMapper.toDto(ciudad)).thenReturn(ciudadDto);

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
        Mockito.when(ciudadRepository.save(ciudad)).thenReturn(ciudad);

        CiudadDto ciudadDto = new CiudadDto(id_ciudad, nombre_ciudad, id_pais, valor_ciudad);
        Mockito.when(ciudadMapper.toDto(ciudad)).thenReturn(ciudadDto);
        Mockito.when(ciudadMapper.toEntity(ciudadDto)).thenReturn(ciudad);

        CiudadDto ciudadDtoExpected = ciudadService.addCiudad(ciudadDto);
        Mockito.verify(ciudadRepository, times(1)).save(ciudad);
        assertThat(ciudadDto).usingRecursiveComparison().isEqualTo(ciudadDtoExpected);
    }

    @ParameterizedTest
    @CsvSource({"14,Elche,1,309"})
    public CiudadDto updateCiudad(CiudadDto ciudadDto, Integer idCiudad) {
        CiudadEntity newCiudad = ciudadMapper.toEntity(ciudadDto);
        return ciudadMapper.toDto(ciudadRepository.findById(idCiudad)
                .map(ciudad -> {
                    ciudad.setIdciudad(newCiudad.getIdciudad());
                    ciudad.setIdpais(newCiudad.getIdpais());
                    ciudad.setNombreciudad(newCiudad.getNombreciudad());
                    ciudad.setValorciudad(newCiudad.getValorciudad());
                    return ciudadRepository.save(ciudad);
                }).orElseGet(() -> {
                    newCiudad.setIdciudad(idCiudad);
                    return ciudadRepository.save(newCiudad);
                })
        );
    }
}
