package com.web.controllers;

import com.web.entities.Alcaldia;
import com.web.entities.Evento;
import com.web.repository.services.AlcaldiaService;
import com.web.repository.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private AlcaldiaService alcaldiaService;

   @GetMapping("")
    public ResponseEntity<?> listar(){
       Map<String, Object> map = new HashMap<String, Object>();
       try{
        List<Evento> eventos= eventoService.findAll();
        if(eventos.isEmpty()){
            map.put("mensaje", "no existen eventos en la bd");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Evento>>(eventos,HttpStatus.OK);
       }catch (DataAccessException | InternalError e){
           return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
       }
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody Evento evento){
        Alcaldia alcadia= alcaldiaService.findById(evento.getAlcaldia().getIdAlcaldia());
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            if(alcadia!=null){
                evento.setAlcaldia(alcadia);
                eventoService.save(evento);
                return new ResponseEntity<Evento>(evento,HttpStatus.OK);
            }
            map.put("error","No se encontro alcaldia para asignar al evento");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }catch (DataAccessException | InternalError e){
            System.out.print(e);
            map.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id,@RequestBody Evento evento){
       Evento eventoEncontrado= eventoService.findById(id);
        Map<String, Object> map = new HashMap<String, Object>();
       if(eventoEncontrado==null){
           map.put("mensaje", "no existen el evento en la bd");
           return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
       }
       Alcaldia alcadia= alcaldiaService.findById(evento.getAlcaldia().getIdAlcaldia());
       eventoEncontrado.setTitulo(evento.getTitulo());
       eventoEncontrado.setDescripcion(evento.getDescripcion());
       eventoEncontrado.setFechaEvento(evento.getFechaEvento());
        if(alcadia==null){
            map.put("error","No se encontro alcaldia para actualizar al evento");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.BAD_REQUEST);
        }
        eventoEncontrado.setAlcaldia(alcadia);
        eventoService.update(eventoEncontrado);
        return new ResponseEntity<Evento>(eventoEncontrado,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
       Evento evento = eventoService.findById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(evento==null){
                map.put("mensaje", "no existen el evento en la bd");
                return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
            }
            eventoService.remove(id);
            map.put("mensaje", "Evento eliminado");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

        }catch (DataAccessException | InternalError e){
            map.put("mensaje", "Evento no pudo ser eliminado!");
            map.put("error", e.getCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
        }

    }


}
