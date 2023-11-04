package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Persona;

@Controller
public class PersonaController {

	@GetMapping("/save")
	public String savePersona(@RequestParam(name = "name", required = false, defaultValue = "carlo") String name, Model model) {
		
		Persona p = new  Persona();
		
		p.setNombre("carlos");
		
		repo.save(p);
		
		model.addAttribute("name",name);
		return "index";
	}
	
}
