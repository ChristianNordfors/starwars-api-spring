package com.xappia.starwars.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xappia.starwars.models.entity.Personaje;
import com.xappia.starwars.models.service.IPersonajeService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonajeController {
	
	@Autowired
	private IPersonajeService personajeService;
	
	
	@PostMapping("/personajes")
	public ResponseEntity<?> crear(@RequestBody Personaje personaje){
		
		Personaje personajeNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		personajeNuevo = personajeService.save(personaje);
		
//		response.put("mensaje", "El personaje " + personaje.getNombre() + " ha sido creado con éxito.");
		response.put("personaje", personajeNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/personajes")
	public ResponseEntity<?> listar() {
		List<Personaje> personajes = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		
		personajes = personajeService.list();
		
		response.put("personajes", personajes);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
