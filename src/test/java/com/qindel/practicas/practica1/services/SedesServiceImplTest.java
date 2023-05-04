package com.qindel.practicas.practica1.services;

import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.apirest.SedeDto;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeEntity;
import com.qindel.practicas.practica1.entities.SedeIDEntity;
import com.qindel.practicas.practica1.mapper.ISedeMapper;
import com.qindel.practicas.practica1.repositories.ISedeRepository;
import com.qindel.practicas.practica1.services.impl.SedeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
public class SedesServiceImplTest {
    @Mock
    private ISedeRepository sedeRepository;

    @InjectMocks
    private SedeServiceImpl sedeService;

    @Mock
    private ISedeMapper sedeMapper;
    
    @Test
    public void getAllSedesTest() {

        List<SedeEntity> sedeesEntity = new ArrayList<>();
        SedeEntity sedeEntity = new SedeEntity();
        sedeEntity.setIdtipojjoo(1);
        sedeEntity.setAnho(2024);
        sedeEntity.setSede(1);
        sedeesEntity.add(sedeEntity);

        List<SedeDto> sedeesDto = new ArrayList<>();
        SedeDto sedeDto = new SedeDto();
        sedeDto.setIdtipojjoo(1);
        sedeDto.setAnho(2024);
        sedeDto.setSede(1);
        sedeesDto.add(sedeDto);

        when(sedeRepository.findAll()).thenReturn(sedeesEntity);
        when(sedeMapper.toDto(sedeEntity)).thenReturn(sedeDto);

        List<SedeDto> result = sedeService.getAllSedes();

        assertEquals(sedeesDto, result);
        verify(sedeRepository, times(1)).findAll();
        verify(sedeMapper, times(1)).toDto(sedeEntity);
    }

    @ParameterizedTest
    @CsvSource({"1900,1,6", "1924,2,8", "2006,1,7"})
    public void getSedeByIdTest(String annoString, String id_tipo_jjooString, String sedeString) {
        Integer anno = Integer.parseInt(annoString);
        Integer id_tipo_jjoo = Integer.parseInt(id_tipo_jjooString);
        Integer sede = Integer.parseInt(sedeString);

        SedeEntity sedeJJOO = new SedeEntity(anno,id_tipo_jjoo, sede);
        Mockito.when(sedeRepository.getReferenceById(new SedeIDEntity(anno,id_tipo_jjoo))).thenReturn(sedeJJOO);

        SedeDto sedeJJOODto = new SedeDto(anno,id_tipo_jjoo, sede);
        Mockito.when(sedeMapper.toDto(sedeJJOO)).thenReturn(sedeJJOODto);

        SedeDto sedeJJOODtoExpected = sedeService.getSedeById(anno, id_tipo_jjoo);
        Mockito.verify(sedeRepository, times(1)).getReferenceById(new SedeIDEntity(anno,id_tipo_jjoo));
        assertThat(sedeJJOODto).usingRecursiveComparison().isEqualTo(sedeJJOODtoExpected);
    }

    @ParameterizedTest
    @CsvSource({"1900,1,6", "1924,2,8", "2006,1,7"})
    public void addSedeJJOOTest(String annoString, String id_tipo_jjooString, String sedeString) throws Exception {
        Integer anno = Integer.parseInt(annoString);
        Integer id_tipo_jjoo = Integer.parseInt(id_tipo_jjooString);
        Integer sede = Integer.parseInt(sedeString);

        SedeEntity sedeJJOO = new SedeEntity(anno,id_tipo_jjoo, sede);
        Mockito.when(sedeRepository.save(sedeJJOO)).thenReturn(sedeJJOO);

        SedeDto sedeJJOODto =  new SedeDto(anno,id_tipo_jjoo, sede);
        Mockito.when(sedeMapper.toDto(sedeJJOO)).thenReturn(sedeJJOODto);
        Mockito.when(sedeMapper.toEntity(sedeJJOODto)).thenReturn(sedeJJOO);

        SedeDto sedeJJOODtoExpected = sedeService.addSede(sedeJJOODto);
        Mockito.verify(sedeRepository, times(1)).save(sedeJJOO);
        assertThat(sedeJJOODto).usingRecursiveComparison().isEqualTo(sedeJJOODtoExpected);

    }

    @ParameterizedTest
    @CsvSource({"1900,1,6,7", "1924,2,8,9", "2006,1,7,8"})
    public void updateSedeJJOOTest(String annoString, String id_tipo_jjooString, String sedeString, String sedeStringNuevo) throws Exception {
        Integer anno = Integer.parseInt(annoString);
        Integer id_tipo_jjoo = Integer.parseInt(id_tipo_jjooString);
        Integer sede = Integer.parseInt(sedeString);
        Integer sedeNueva = Integer.parseInt(sedeStringNuevo);

        SedeEntity sedeJJOO = new SedeEntity(anno,id_tipo_jjoo, sede);
        SedeEntity sedeJJOONew = new SedeEntity(anno,id_tipo_jjoo, sedeNueva);
        SedeDto sedeJJOODto = new SedeDto(anno,id_tipo_jjoo, sedeNueva);

        Mockito.when(sedeRepository.getReferenceById(new SedeIDEntity(anno,id_tipo_jjoo))).thenReturn(sedeJJOO);
        Mockito.when(sedeRepository.findById(new SedeIDEntity(anno,id_tipo_jjoo))).thenReturn(Optional.of(sedeJJOO));
        Mockito.when(sedeRepository.save(sedeJJOO)).thenReturn(sedeJJOO);
        Mockito.when(sedeMapper.toEntity(sedeJJOODto)).thenReturn(sedeJJOONew);
        Mockito.when(sedeMapper.toDto(sedeJJOO)).thenReturn(sedeJJOODto);
        SedeDto sedeJJOODtoNewExpected = sedeService.updateSede(sedeJJOODto, anno, id_tipo_jjoo);

        Mockito.verify(sedeRepository, times(1)).findById(new SedeIDEntity(anno,id_tipo_jjoo));
        Mockito.verify(sedeRepository, times(1)).save(sedeJJOO);
        assertThat(sedeJJOODto).isEqualTo(sedeJJOODtoNewExpected);
    }

    @ParameterizedTest
    @CsvSource({"1900,1,7", "1924,2,9", "2006,1,8"})
    public void updateSedeJJOONotFoundTest(String annoString, String id_tipo_jjooString, String sedeStringNuevo) throws Exception {
        Integer anno = Integer.parseInt(annoString);
        Integer id_tipo_jjoo = Integer.parseInt(id_tipo_jjooString);
        Integer sedeNueva = Integer.parseInt(sedeStringNuevo);
        SedeEntity sedeJJOONew = new SedeEntity(anno,id_tipo_jjoo, sedeNueva);
        SedeDto sedeJJOODto = new SedeDto(anno,id_tipo_jjoo, sedeNueva);


        Mockito.when(sedeRepository.findById(new SedeIDEntity(anno,id_tipo_jjoo))).thenReturn(Optional.empty());
        Mockito.when(sedeRepository.save(sedeJJOONew)).thenReturn(sedeJJOONew);
        Mockito.when(sedeMapper.toEntity(sedeJJOODto)).thenReturn(sedeJJOONew);
        Mockito.when(sedeMapper.toDto(sedeJJOONew)).thenReturn(sedeJJOODto);
        SedeDto sedeJJOODtoNewExpected = sedeService.updateSede(sedeJJOODto, anno, id_tipo_jjoo);

        Mockito.verify(sedeRepository, times(1)).findById(new SedeIDEntity(anno,id_tipo_jjoo));
        Mockito.verify(sedeRepository, times(1)).save(sedeJJOONew);
        assertThat(sedeJJOODto).isEqualTo(sedeJJOODtoNewExpected);
    }
}
