package com.curso.m13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.curso.m13.model.Empleado;

@Repository
public class EmpleadoRepositoryN1 implements IEmpleadoRepositoryN1 {

	private List<Empleado> empleados = null;

	public EmpleadoRepositoryN1() {
		this.empleados = new ArrayList<Empleado>();
		empleados.add(new Empleado(1, "pepe", 1000, "CTO"));
		empleados.add(new Empleado(2, "jose", 1000, "PM"));
		empleados.add(new Empleado(3, "toni", 1000, "CONSULTOR"));
	}

	public List<Empleado> findAll() {
		return empleados;
	}

	public Empleado findById(int id) {
		List<Empleado>	aux = 	empleados.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
		if (aux.size()>0 && aux!= null)
			return aux.get(0);
		else
			return null;
	}

	public boolean deleteById(int id) {
		return empleados.removeIf(e -> e.getId() == id);
	}

	public void save(Empleado empleadoDto) {
		List<Empleado>	aux = 	empleados.stream().filter(s -> s.getId() == empleadoDto.getId()).collect(Collectors.toList());
		if (aux.size()>0 && aux!= null)
			empleados.set(empleados.indexOf(aux.get(0)), empleadoDto);
		else
			empleados.add(empleadoDto);
	}

}
