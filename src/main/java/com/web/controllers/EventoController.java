package com.web.controllers;

import com.web.entities.Evento;
import com.web.repository.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/evento")
@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody Evento evento){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            eventoService.save(evento);
            return new ResponseEntity<Evento>(evento,HttpStatus.OK);
        }catch (DataAccessException | InternalError e){
            System.out.print(e);
            map.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
        }
    }
}