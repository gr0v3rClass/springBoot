package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.CruDspringBootApplication;
import com.example.demo.model.entity.Empleado;
import com.example.demo.service.EmpleadoService;


@Controller
public class empleadoController {
	
	private static Logger LOG = LoggerFactory.getLogger(CruDspringBootApplication.class); 
	
	@Autowired
	private EmpleadoService empServ;
	
	@GetMapping("/")
	public ModelAndView vistaIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("listaEmpleados", empServ.getAllEmpleados());
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
	
	@GetMapping("/eliminarEmpleado/{id}")
	public String deleteEmpleado(@PathVariable(value = "id") int id) {
		empServ.deleteEmpleado(id);
		return "redirect:/";
	}
	
	@GetMapping("/showFormActualizar/{id}")
	public ModelAndView showFormActualizar(@PathVariable(value="id") int id){
		ModelAndView modelAndView = new ModelAndView();
		
		Empleado empleado = empServ.getEmpleado(id);
		
		modelAndView.addObject("empleado", empleado);
		modelAndView.setViewName("update_empleado");
		
		return modelAndView;
	}
}

