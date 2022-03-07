package com.jpsdiu.tutorial.service;

import com.jpsdiu.tutorial.model.TutorialesVO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TutorialesService {

    List<TutorialesVO> getAllTutorials();
    TutorialesVO createTutorial(TutorialesVO tutorial);
    ResponseEntity<TutorialesVO> findTutorialById(String id);
    List<TutorialesVO> findByPublished();
    ResponseEntity<TutorialesVO> deleteTutorial(String id);
    ResponseEntity<TutorialesVO> updateTutorial(TutorialesVO tutorial, String id);
    ResponseEntity<TutorialesVO> deleteAllTutorials();
}
