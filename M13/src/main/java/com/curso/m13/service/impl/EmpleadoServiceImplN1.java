package com.curso.m13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m13.model.Empleado;
import com.curso.m13.repository.IEmpleadoRepositoryN1;
import com.curso.m13.service.contract.*;

@Service
public class EmpleadoServiceImplN1 implements IEmpleadoServiceN1 {
	
	/** N1 - ARRAY repository. **/
	 @Autowired
	 private final IEmpleadoRepositoryN1 empleadoRepository;

	public EmpleadoServiceImplN1(IEmpleadoRepositoryN1 empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	public Empleado findById(int id) {
		return empleadoRepository.findById(id);
	}

	public void deletebyId(int id) {
		 empleadoRepository.deleteById(id);
	}

	public void saveOrUpdate(Empleado empleadoDto) {
		empleadoRepository.save(empleadoDto);
	}

}
