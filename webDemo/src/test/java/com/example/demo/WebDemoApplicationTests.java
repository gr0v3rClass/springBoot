package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Usuario;
import com.example.demo.repo.IUsuarioRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
class WebDemoApplicationTests {

		//@Autowired
		private IUsuarioRepo repo;
		
		//@Autowired
		private BCryptPasswordEncoder encoder;
		
		@Test
		public void crearUsuarioTest() {
			Usuario us = new Usuario();
			us.setId(1);
			us.setNombre("admin");
			//us.setClave(encoder.encode("admin"));		
			Usuario retorno = repo.save(us);
			
			assertTrue(retorno.getClave().equalsIgnoreCase(us.getClave()));
		}

}
