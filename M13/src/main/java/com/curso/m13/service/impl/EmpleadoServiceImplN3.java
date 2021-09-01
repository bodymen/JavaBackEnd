package com.curso.m13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m13.model.Empleado;
import com.curso.m13.repository.IEmpleadoRepositoryN1;
import com.curso.m13.repository.IEmpleadoRepositoryN3;
import com.curso.m13.service.contract.IEmpleadoServiceN3;

@Service
public class EmpleadoServiceImplN3 implements IEmpleadoServiceN3 {
	

	/** N3 -MySQL repository JPA **/
	 @Autowired
	 private final IEmpleadoRepositoryN3 empleadoRepository;

	public EmpleadoServiceImplN3(IEmpleadoRepositoryN3 empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	public Empleado findById(int id) {
		return empleadoRepository.findById(id).get();
	}

	public void deletebyId(int id) {
		 empleadoRepository.deleteById(id);
	}

	public void saveOrUpdate(Empleado empleadoDto) {
		empleadoRepository.save(empleadoDto);
	}

}
