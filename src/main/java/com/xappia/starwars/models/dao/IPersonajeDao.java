package com.xappia.starwars.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.xappia.starwars.models.entity.Personaje;

public interface IPersonajeDao extends CrudRepository<Personaje, Long> {
	
	

}
