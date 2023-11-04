package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Empleado copyEmpleadoToEntity(Empleado empleado) {
		Empleado empleadoentity = new Empleado();
		BeanUtils.copyProperties(empleado, empleadoentity);
		return empleadoentity;
	}
	
	
}
