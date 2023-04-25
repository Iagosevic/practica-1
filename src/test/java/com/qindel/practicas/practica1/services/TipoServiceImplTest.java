package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.TipoDto;
import com.qindel.practicas.practica1.entities.TipoEntity;
import com.qindel.practicas.practica1.mapper.ITipoMapper;
import com.qindel.practicas.practica1.repositories.ITipoRepository;
import com.qindel.practicas.practica1.services.impl.TipoServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
@SpringBootTest
public class TipoServiceImplTest {
    @Mock
    private ITipoRepository tipoRepository;

    @InjectMocks
    private TipoServiceImpl tipoService;

    @Mock
    private ITipoMapper tipoMapper;


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
    public TipoDto updateTipo(TipoDto tipoDto, Integer idTipo) {
        TipoEntity newTipo = tipoMapper.toEntity(tipoDto);
        return tipoMapper.toDto(tipoRepository.findById(idTipo)
                .map(tipo -> {
                    tipo.setIdtipojjoo(newTipo.getIdtipojjoo());
                    tipo.setDescripciontipo(newTipo.getDescripciontipo());
                    return tipoRepository.save(tipo);
                }).orElseGet(() -> {
                    newTipo.setIdtipojjoo(idTipo);
                    return tipoRepository.save(newTipo);
                })
        );
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
}
