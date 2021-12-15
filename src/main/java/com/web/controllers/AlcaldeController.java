package com.web.controllers;

import com.web.entities.Alcalde;
import com.web.repository.services.AlcaldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alcalde")
public class AlcaldeController {
    @Autowired
    private AlcaldeService alcaldeService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(alcaldeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(alcaldeService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Alcalde alcalde){
        return  ResponseEntity.status(HttpStatus.CREATED).body(alcaldeService.save(alcalde));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        Alcalde alcalde= alcaldeService.findById(id);
        return ResponseEntity.ok(alcaldeService.update(alcalde));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        alcaldeService.remove(id);
        return ResponseEntity.ok().build();
    }

}
