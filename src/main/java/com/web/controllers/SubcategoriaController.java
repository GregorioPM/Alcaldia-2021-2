package com.web.controllers;



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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.web.entities.Categoria;

import com.web.entities.SubCategoria;

import com.web.repository.services.CategoriaService;
import com.web.repository.services.SubcategoriaService;

//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652 SUBCATEGORIA

@CrossOrigin("*")
@RestController
@RequestMapping("/Categoria/Subcategoria")
public class SubcategoriaController {

	@Autowired
	private SubcategoriaService service;

	@Autowired
	private CategoriaService categoriaservice;

	
	@GetMapping("")
	public ResponseEntity<?> listarSubCategorias(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SubCategoria> subcategoria = service.findAll();
			if(subcategoria.isEmpty()) {
				map.put("mensaje", "no existen subcategorias en la bd");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<SubCategoria>>(subcategoria, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{idCategoria}/")
	public ResponseEntity<?> listarPorCategoria(@PathVariable Categoria categoria){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<SubCategoria> subcategoria = service.findByCategoria(categoria);
			if(subcategoria == null) {
				map.put("mensaje", "no existe la subcategorias");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<SubCategoria>>(subcategoria, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{idSubCategoria}")
	public ResponseEntity<?> listarPorCategoria(@PathVariable int idSubCategoria){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SubCategoria subcategoria = service.findById(idSubCategoria);
			if(subcategoria == null) {
				map.put("mensaje", "no existe la subcategoria");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<SubCategoria>(subcategoria, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PostMapping("/save/{idCategoria}")
	public ResponseEntity<?> guardarSubcategoria(@PathVariable int idCategoria,@RequestBody SubCategoria subcategoria){
		Categoria cat=this.categoriaservice.findById(idCategoria);
		Map <String,Object>map =new HashMap<>();
		if(cat==null) {
			map.put("mensaje", "nose encontro la categoria al cual asignarse");
			return new ResponseEntity<Map <String,Object>>(map,HttpStatus.NOT_FOUND);
		}
		
		try {
			
			subcategoria.setCategoria(cat);
			
			map.put("subcategoria",this.service.save(subcategoria));
			map.put("mensaje", "subcategoria agregado correctamente");
			return new ResponseEntity<Map <String,Object>>(map,HttpStatus.CREATED);
			
		}catch (Exception e) {
			map.put("error", e.getMessage());
			map.put("mensaje", "No se pudo agreagar el mensaje");
			return new ResponseEntity<Map <String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@DeleteMapping("/subcategorias/{id}")
	public ResponseEntity<?>eliminar(@PathVariable int id){
		Map <String,Object> map=new HashMap<>();
		
			try {
				this.service.remove(id);
				map.put("mensaje", "paso eliminado correctamente");
				return new ResponseEntity<Map <String,Object>>(map,HttpStatus.OK);
			}catch (DataAccessException e) {
				map.put("mensaje", "el Id no existe en la base de datos");
				map.put("error",e.getMessage());
				return new ResponseEntity<Map <String,Object>>(map,HttpStatus.NOT_FOUND);
			}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody SubCategoria subcategoria) {
		SubCategoria subcat=this.service.findById(id);
		
		if(subcat==null) {
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "La subcategoria a actulizar no se encontro en la base de datos");
			map.put("error", "La subcategoria en la bd no existe");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			subcat.setDescripcion(subcategoria.getDescripcion());
			subcat.setIdSubCategoria(subcategoria.getIdSubCategoria());
			subcat.setOrden(subcategoria.getOrden());
			subcat.setTitulo(subcategoria.getTitulo());
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "subcategoria actualizado corrctamente");
			map.put("subcategoria", this.service.save(subcat));
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "La alcaldia no se pudo actualizar");
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	

	

	

}
