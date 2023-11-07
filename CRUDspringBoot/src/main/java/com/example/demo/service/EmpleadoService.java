package com.example.demo.service;

import java.util.List;

import com.example.demo.model.entity.Empleado;

public interface EmpleadoService {
	void saveEmpleado(Empleado empleado);
	List<Empleado> getAllEmpleados();
	void deleteEmpleado(Integer id);
	Empleado getEmpleado(Integer id);
	
}
