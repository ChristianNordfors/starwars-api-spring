package com.xappia.starwars.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xappia.starwars.models.dao.IPersonajeDao;
import com.xappia.starwars.models.entity.Personaje;

@Service
public class PersonajeServiceImpl implements IPersonajeService {
	
	@Autowired
	private IPersonajeDao personajeDao;

	@Override
	@Transactional
	public Personaje save(Personaje personaje) {
		return personajeDao.save(personaje);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Personaje> list() {
		return (List<Personaje>) personajeDao.findAll();
	}

}
