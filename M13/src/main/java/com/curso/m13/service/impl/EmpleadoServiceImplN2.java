package com.curso.m13.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m13.model.Empleado;
import com.curso.m13.repository.IEmpleadoRepositoryN1;
import com.curso.m13.repository.IEmpleadoRepositoryN2;
import com.curso.m13.repository.IEmpleadoRepositoryN3;
import com.curso.m13.service.contract.IEmpleadoServiceN2;
import com.curso.m13.service.contract.IEmpleadoServiceN3;

@Service
public class EmpleadoServiceImplN2 implements IEmpleadoServiceN2 {
	

	/** N2 -MySQL repository JDBC **/
	 @Autowired
	 private final IEmpleadoRepositoryN2 empleadoRepository;

	public EmpleadoServiceImplN2(IEmpleadoRepositoryN2 empleadoRepository) {
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
	
	public void update(Empleado empleadoDto) {
		empleadoRepository.update(empleadoDto);
	}

}
