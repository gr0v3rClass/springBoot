package com.example.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.SbDemo2Application;

@Repository
@Qualifier("persona1")
public class PersonaRepoImpl implements IPersonaRepo{
	
	private static Logger LOG = LoggerFactory.getLogger(SbDemo2Application.class);

	@Override
	public void registrar(String nombre) {
		// TODO Auto-generated method stub
		
		LOG.info("Se registro a: "+nombre);
	}

}
