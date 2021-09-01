package com.curso.m13.service.contract;

import java.util.List;

import com.curso.m13.model.Empleado;

public interface IEmpleadoServiceN1 {

	  List<Empleado> findAll() ;

      Empleado findById(int id) ;

      void deletebyId(int id) ;

      void saveOrUpdate(Empleado empleadoDto) ;
	
}
