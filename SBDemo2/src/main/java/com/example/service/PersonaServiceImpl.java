package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.repository.IPersonaRepo;
//import com.example.repository.PersonaRepoImpl;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	@Qualifier("persona1")
	private IPersonaRepo repo;
	
	@Override
	public void registrar(String nombre) {
		// TODO Auto-generated method stub
		//repo = new PersonaRepoImpl();
		repo.registrar(nombre);
		
	}

	
}
