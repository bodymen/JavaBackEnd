package com.curso.m13.repository;

import java.util.List;

import com.curso.m13.model.Empleado;

public interface IEmpleadoRepositoryN2 {

	  List<Empleado> findAll() ;

      Empleado findById(int id) ;

      void deleteById(int id) ;

      void save(Empleado empleadoDto) ;
      
      void update(Empleado empleadoDto) ;
;}
