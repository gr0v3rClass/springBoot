package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.entity.Empleado;
import com.example.demo.service.EmpleadoService;

@Controller
public class empleadoController {
	@Autowired
	private EmpleadoService empServ;
	
	@GetMapping("/")
	public ModelAndView vistaIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/viewNuevoEmpleadoForm")
	public ModelAndView viewNuevoEmpleadoForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("empleado", new Empleado());
		modelAndView.setViewName("new_empleado");
		return modelAndView;
	}
	
	@PostMapping("/saveEmpleado")
	public String saveEmpleado(@ModelAttribute("Empleado") Empleado empleado ) {
		empServ.saveEmpleado(empleado);
		return "redirect:/";
	}
}
