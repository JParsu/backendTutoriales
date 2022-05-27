package com.jpsdiu.tutorial.service.impl;

import com.jpsdiu.tutorial.exceptions.exception.TitleIsEmptyException;
import com.jpsdiu.tutorial.exceptions.exception.TutorialNotFoundException;
import com.jpsdiu.tutorial.model.TutorialesVO;
import com.jpsdiu.tutorial.repository.TutorialesRepository;
import com.jpsdiu.tutorial.service.TutorialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialesServiceImpl implements TutorialesService {

    @Autowired
    private TutorialesRepository tutorialesRepository;


    @Override
    public List<TutorialesVO> getAllTutorials() {
        return tutorialesRepository.findAll();
    }

    @Override
    public TutorialesVO createTutorial(TutorialesVO tutorial) throws TitleIsEmptyException{
        if(tutorial.getTitulo()==null){
            throw new TitleIsEmptyException();
        }
        return tutorialesRepository.insert(tutorial);
    }

    @Override
    public ResponseEntity<TutorialesVO> findTutorialById(String id) throws TutorialNotFoundException{
        if(tutorialesRepository.existsById(id)){
            Optional<TutorialesVO> buscado = tutorialesRepository.findById(id);
            return ResponseEntity.of(buscado);
        }else{
        throw new TutorialNotFoundException();
        }
    }

    @Override
    public List<TutorialesVO> findByPublished() {
        return tutorialesRepository.findByPublicadoTrue();
    }

    @Override
    public ResponseEntity<TutorialesVO> deleteTutorial(String id) throws TutorialNotFoundException{
        if(tutorialesRepository.existsById(id)){
        tutorialesRepository.deleteById(id);
        return ResponseEntity.ok().build();
        }else{
        throw new TutorialNotFoundException();
        }
    }

    @Override
    public ResponseEntity<TutorialesVO> updateTutorial(TutorialesVO tutorial, String id) {
        if(tutorialesRepository.existsById(id)) {
            tutorialesRepository.save(tutorial);
            return ResponseEntity.ok(tutorial);
        }else{
        return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<TutorialesVO> deleteAllTutorials() {
        tutorialesRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
