package com.jpsdiu.tutorial.controller;

import com.jpsdiu.tutorial.model.TutorialesVO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TutorialesAPI {
    List<TutorialesVO> getAllTutorials();
    TutorialesVO createTutorial(TutorialesVO tutorial);
    ResponseEntity<TutorialesVO> findTutorialById(String id);
    List<TutorialesVO> findByPublish();
    ResponseEntity<TutorialesVO> deleteTutorial(String id);
    ResponseEntity<TutorialesVO> updateTutorial(TutorialesVO tutorial, String id);
    ResponseEntity<TutorialesVO> deleteAllTutorials();
}
