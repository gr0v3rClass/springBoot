package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.BeanAccess;

import com.example.demo.model.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empRepo;
	
	@Override
	public void saveEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		
		//Empleado empleado1 = new Empleado();
		
		//empleado1.setNombre("flora");
		
		
		empRepo.save(copyEmpleadoToEntity(empleado));
	}
	
	@Override
	public List<Empleado> getAllEmpleados() {
		// TODO Auto-generated method stub
		List<Empleado> empleados = empRepo.findAll();
		return empleados.stream().map(empl -> copyEmpleadoEntityToDto(empl)).collect(Collectors.toList());
	}
	
	public Empleado copyEmpleadoToEntity(Empleado empleado) {
		Empleado empleadoentity = new Empleado();
		BeanUtils.copyProperties(empleado, empleadoentity);
		return empleadoentity;
	}
	
	public Empleado copyEmpleadoEntityToDto(Empleado empleado){
		Empleado empleadoo = new Empleado();
		BeanUtils.copyProperties(empleado, empleadoo);
		return empleadoo;
	}

	@Override
	public void deleteEmpleado(Integer id) {
		// TODO Auto-generated method stub
		this.empRepo.deleteById(id);
	}

	@Override
	public Empleado getEmpleado(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Empleado> empleadoOpcional = empRepo.findById(id);
		Empleado empleado = null;
		
		if (empleadoOpcional.isPresent()) {
			empleado = copyEmpleadoEntityToDto(empleadoOpcional.get());
		}else {
			throw new RuntimeException("El id del empleado no existe "+ id);
		}
		return empleado;
	}
	
}
