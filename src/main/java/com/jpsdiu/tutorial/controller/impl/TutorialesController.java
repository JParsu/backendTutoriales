package com.jpsdiu.tutorial.controller.impl;

import com.jpsdiu.tutorial.controller.TutorialesAPI;
import com.jpsdiu.tutorial.model.TutorialesVO;
import com.jpsdiu.tutorial.service.TutorialesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tutorials")
public class TutorialesController implements TutorialesAPI {

    @Autowired
    private TutorialesService tutorialesService;
    @Override
    @GetMapping("/all")
    public List<TutorialesVO> getAllTutorials() {
        return tutorialesService.getAllTutorials();
    }
    @Override
    @PostMapping
    public TutorialesVO createTutorial(@RequestBody TutorialesVO tutorial) {
        return tutorialesService.createTutorial(tutorial);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TutorialesVO> findTutorialById(@PathVariable("id") String id) {
        return tutorialesService.findTutorialById(id);
    }

    @Override
    @GetMapping("/published")
    public List<TutorialesVO> findByPublish() {
        return tutorialesService.findByPublished();
    }

    @Override
    @DeleteMapping("delete/{id}")
    public ResponseEntity<TutorialesVO> deleteTutorial(@PathVariable("id") String id) {
        return tutorialesService.deleteTutorial(id);
    }

    @Override
    @PutMapping("/edit/{id}")
    public ResponseEntity<TutorialesVO> updateTutorial(@RequestBody TutorialesVO tutorial, @PathVariable("id") String id) {
        return tutorialesService.updateTutorial(tutorial,id);
    }

    @Override
    @DeleteMapping("/deleteAll")
    public ResponseEntity<TutorialesVO> deleteAllTutorials() {
        return tutorialesService.deleteAllTutorials();
    }
}
