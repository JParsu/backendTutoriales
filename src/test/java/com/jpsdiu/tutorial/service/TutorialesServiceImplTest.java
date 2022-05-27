package com.jpsdiu.tutorial.service;

import com.jpsdiu.tutorial.exceptions.exception.TitleIsEmptyException;
import com.jpsdiu.tutorial.exceptions.exception.TutorialNotFoundException;
import com.jpsdiu.tutorial.model.TutorialesVO;
import com.jpsdiu.tutorial.repository.TutorialesRepository;
import com.jpsdiu.tutorial.service.impl.TutorialesServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TutorialesServiceImplTest {

    @Mock
    TutorialesRepository tutorialesRepository;

    @InjectMocks
    TutorialesServiceImpl tutorialesService;

    TutorialesVO tutoriales;

    @BeforeEach
    void initialize(){
        tutoriales = TutorialesVO.builder().titulo("Ejemplo").descripcion("Este es un tutorial de ejemplo").publicado(true).build();
    }

    @Test
    void getAllTutorials_OK() {
        List<TutorialesVO> list = new ArrayList<>();
        list.add(tutoriales);

        Mockito.when(tutorialesRepository.findAll()).thenReturn(list);

        Assertions.assertSame(list.get(0).getTitulo(),tutorialesService.getAllTutorials().get(0).getTitulo());
    }

    @Test
    void createNewTutorial_OK() {

        Mockito.when(tutorialesRepository.insert(tutoriales)).thenReturn(tutoriales);

        Assertions.assertEquals(tutoriales.getTitulo(),tutorialesService.createTutorial(tutoriales).getTitulo());
    }

    @Test
    void createNewTutorial_TitleIsEmpty() {
        TutorialesVO tutorialSinTitulo = TutorialesVO.builder().descripcion("Paco").publicado(false).build();

        Assertions.assertThrows(TitleIsEmptyException.class, () -> tutorialesService.createTutorial(tutorialSinTitulo));
    }

    @Test
    void findTutorialById_Ok() {

        Mockito.when(tutorialesRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(tutorialesRepository.findById(Mockito.any())).thenReturn(Optional.of(tutoriales));

        Assertions.assertSame(tutoriales.getTitulo(),tutorialesService.findTutorialById("1").getBody().getTitulo());
    }

    @Test
    void findTutorialById_NotFound() {

        Assertions.assertThrows(TutorialNotFoundException.class, () -> tutorialesService.findTutorialById("1"));
    }

    @Test
    void findTutorialByPublished_OK() {
            List<TutorialesVO> list = new ArrayList<>();
            list.add(tutoriales);

            Mockito.when(tutorialesRepository.findByPublicadoTrue()).thenReturn(list);

            Assertions.assertSame(list,tutorialesService.findByPublished());
    }

    @Test
    void deleteTutorialById_OK() {

        Mockito.when(tutorialesRepository.existsById(Mockito.any())).thenReturn(true);

        Assertions.assertSame(HttpStatus.OK,tutorialesService.deleteTutorial("1").getStatusCode());
    }

    @Test
    void deleteTutorialById_TutorialNotFound() {

        Assertions.assertThrows(TutorialNotFoundException.class, () -> tutorialesService.deleteTutorial("1"));
    }

    @Test
    void updateTutorialById_OK() {

        Mockito.when(tutorialesRepository.existsById(Mockito.any())).thenReturn(true);
        Mockito.when(tutorialesRepository.save(Mockito.any())).thenReturn(tutoriales);

        Assertions.assertSame(tutoriales,tutorialesService.updateTutorial(tutoriales,"1").getBody());

    }

    @Test
    void updateTutorialById_NotFound() {

        Assertions.assertThrows(TutorialNotFoundException.class, () -> tutorialesService.deleteTutorial("1"));

    }

    @Test
    void deleteAllTutorials_OK() {

        Assertions.assertSame(HttpStatus.OK,tutorialesService.deleteAllTutorials().getStatusCode());
    }
}
