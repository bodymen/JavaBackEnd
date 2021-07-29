package com.curso.m13.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.curso.m13.dto.EmpleadoDto;

@Repository
public class EmpleadoRepository implements IEmpleadoRepository {

	private List<EmpleadoDto> empleados = null;

	public EmpleadoRepository() {
		this.empleados = new ArrayList<EmpleadoDto>();
		empleados.add(new EmpleadoDto(1, "pepe", 1000, "CTO"));
		empleados.add(new EmpleadoDto(2, "jose", 1000, "PM"));
		empleados.add(new EmpleadoDto(3, "toni", 1000, "CONSULTOR"));
	}

	public List<EmpleadoDto> findAll() {
		return empleados;
	}

	public EmpleadoDto findAllById(int id) {
		List<EmpleadoDto>	aux = 	empleados.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
		if (aux.size()>0 && aux!= null)
			return aux.get(0);
		else
			return null;
	}

	public boolean deletebyId(int id) {
		return empleados.removeIf(e -> e.getId() == id);
	}

	public void saveOrUpdate(EmpleadoDto empleadoDto) {
		List<EmpleadoDto>	aux = 	empleados.stream().filter(s -> s.getId() == empleadoDto.getId()).collect(Collectors.toList());
		if (aux.size()>0 && aux!= null)
			empleados.set(empleados.indexOf(aux.get(0)), empleadoDto);
		else
			empleados.add(empleadoDto);
	}

}
