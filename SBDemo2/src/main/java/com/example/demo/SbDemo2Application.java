package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.service.IPersonaService;


//import com.example.service.PersonaServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.service")
public class SbDemo2Application implements CommandLineRunner  {
	
	@Autowired(required = true)
	private IPersonaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SbDemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//service = new PersonaServiceImpl();
		service.registrar("Pedro");
		
	}
	
	

}
