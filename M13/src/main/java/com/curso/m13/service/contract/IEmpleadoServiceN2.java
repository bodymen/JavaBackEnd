package com.curso.m13.service.contract;

import java.util.List;

import com.curso.m13.model.Empleado;

public interface IEmpleadoServiceN2 {

	  List<Empleado> findAll() ;

      Empleado findById(int id) ;

      void deletebyId(int id) ;

      void saveOrUpdate(Empleado empleadoDto) ;
      
      void update(Empleado empleadoDto) ;
	
}
