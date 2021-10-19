package com.web.controllers;



import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.entities.Alcaldia;
import com.web.repository.services.AlcaldiaService;
import com.web.repository.services.IUploadFileService;


//KEVIN ENRIQUE JIMENEZ SANCHEZ COD:1151652 Alcaldia
@CrossOrigin("*")
@RestController
@RequestMapping("/alcaldia")
public class AlcaldiaController {

	@Autowired
	private AlcaldiaService service;
	
	@Autowired 
	private IUploadFileService uploadService;
	

	@GetMapping("")
	public ResponseEntity<?> listarAlcaldia(){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Alcaldia> alcaldia = service.findAll();
			if(alcaldia.isEmpty()) {
				map.put("mensaje", "no existen alcadia en la bd");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Alcaldia>>(alcaldia, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PostMapping("/save")
	public ResponseEntity<?> guardar(@ModelAttribute Alcaldia alcaldia, Principal principal, @RequestParam("files") MultipartFile files) throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if(files.isEmpty()) {	
				
				map.put("mensaje", "no se envio ninguna imagen");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			
			uploadService.copy(files);
			alcaldia.setLogo(files.getOriginalFilename());
			service.guardar(alcaldia);
			
			
			return new ResponseEntity<Alcaldia>(alcaldia, HttpStatus.OK);

		} catch (DataAccessException | InternalError e) {
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@DeleteMapping("/{idAlcaldia}")
	public ResponseEntity<?> eliminar(@PathVariable int idAlcaldia){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Alcaldia alcaldia = service.findById(idAlcaldia);
			if(alcaldia == null) {
				map.put("mensaje", "no se pudo eliminar");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
			}
			service.remove(idAlcaldia);
			map.put("mensaje", "Alcaldia eliminada");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (DataAccessException | InternalError e) {
			map.put("mensaje", "Alcaldia no pudo ser eliminado!");
			map.put("error", e.getCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
	}
	
	@Secured({"ROLE_ADMIN","ROLE_COMUNICADOR"})
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id,@RequestBody Alcaldia alcalida, @RequestParam("files") MultipartFile files) {
		Alcaldia alca=this.service.findById(id);
		
		if(alca==null) {
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "La alcaldia a actulizar no se encontro en la base de datos");
			map.put("error", "La alcalida en la bd no existe");
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		}
		if(files.isEmpty()) {	
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "no se envio ninguna imagen");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			
			alca.setAlcalde(alcalida.getAlcalde());
			alca.setCorreo(alcalida.getCorreo());
			alca.setDireccion(alcalida.getDireccion());
			alca.setHorarioAtencion(alcalida.getHorarioAtencion());
			alca.setIdAlcaldia(alcalida.getIdAlcaldia());
			alca.setLogo(files.getOriginalFilename());
			alca.setNombre(alcalida.getNombre());
			alca.setTelefono(alcalida.getTelefono());
			uploadService.copy(files);
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "Alcaldia actualizado corrctamente");
			map.put("Alcaldia", this.service.guardar(alca));
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		} catch (Exception e) {
			
			Map<String, Object> map=new HashMap<>();
			map.put("mensaje", "El Alcaldia no se pudo actualizar");
			map.put("error", e.getMessage());
			return new ResponseEntity<Map<String,Object>>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	}

	

	


