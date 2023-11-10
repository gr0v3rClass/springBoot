package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RestSpringBootApplication;
import com.example.demo.modelo.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoControlle {
	
	private static Logger LOG = LoggerFactory.getLogger(RestSpringBootApplication.class);
	
	@Autowired
	private EmpleadoRepository empRepo;
	
	@GetMapping("/empleados")
	public List<Empleado> listaTodosLosEmpleados(){
		return empRepo.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> obtenerEmpleado(@PathVariable Long id){
		Empleado empleado = empRepo.findById(id).orElseThrow();
		return ResponseEntity.ok(empleado);
	}
	
	@PostMapping("/empleados")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		String nombre = empleado.getNombre();
		String apellido = empleado.getApellido();
		LOG.info("nombre: "+ nombre + " "+apellido);
		return empRepo.save(empleado);
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable long id,@RequestBody Empleado empleadoActualizar){
		
		Empleado empleado = empRepo.findById(id).orElseThrow();
		
		empleado.setNombre(empleadoActualizar.getNombre());
		empleado.setApellido(empleadoActualizar.getApellido());
		
		Empleado empleadoActualizado = empRepo.save(empleado);
		
		return ResponseEntity.ok(empleadoActualizado);
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id){
		Empleado empleado = empRepo.findById(id).orElseThrow();
		
		empRepo.delete(empleado);
		
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("Eliminado", Boolean.TRUE);
		
		return ResponseEntity.ok(respuesta);
	}
}
