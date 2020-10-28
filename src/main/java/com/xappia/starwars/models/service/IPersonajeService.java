package com.xappia.starwars.models.service;

import java.util.List;

import com.xappia.starwars.models.entity.Personaje;

public interface IPersonajeService {
	
	public Personaje save(Personaje personaje);
	
	public List<Personaje> list();

}
