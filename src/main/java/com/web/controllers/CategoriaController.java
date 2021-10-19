package com.web.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.web.entities.Categoria;
import com.web.repository.services.CategoriaService;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652 CATEGORIA

@CrossOrigin("*")
@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping("")
	public ResponseEntity<?> listarCategorias(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Categoria> categoria = service.findAll();
			if(categoria.isEmpty()) {
				map.put("mensaje", "no existen categorias en la bd");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Categoria>>(categoria, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<?> listarPorCategoria(@PathVariable int idCategoria){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Categoria categoria = service.findById(idCategoria);
			if(categoria == null) {
				map.put("mensaje", "no existe la categoria");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PostMapping("/save")
	public ResponseEntity<?> guardar(@ModelAttribute Categoria categoria, Principal principal){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			service.save(categoria);
			
			
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);

		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<?> eliminar(@PathVariable int idCategoria){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Categoria categoria = service.findById(idCategoria);
			if(categoria == null) {
				map.put("mensaje", "no se pudo eliminar");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			service.remove(idCategoria);
			map.put("mensaje", "Categoria eliminada");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("mensaje", "Categoria no pudo ser eliminado!");
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Categoria categoria) {
		Categoria cat=this.service.findById(id);
		
		if(cat==null) {
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "La categoria a actulizar no se encontro en la base de datos");
			map.put("error", "La categoria en la bd no existe");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			cat.setDescripcion(categoria.getDescripcion());
			cat.setIdCategoria(categoria.getIdCategoria());
			cat.setOrden(categoria.getOrden());
			cat.setTitulo(categoria.getTitulo());
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "categoria actualizado corrctamente");
			map.put("categoria", this.service.save(cat));
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "La categoria no se pudo actualizar");
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

	

}

