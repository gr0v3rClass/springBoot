package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbDemo1Application implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(SbDemo1Application.class); 

	public static void main(String[] args) {
		SpringApplication.run(SbDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//System.out.println("hola desde consola.....");
		
		LOG.info("hola desde la consola....");
		LOG.error("mensaje de erro...");
		LOG.warn("mensaje de advertencia....");
		LOG.debug("mensaje de depuracion....");
		
	}

	
}
