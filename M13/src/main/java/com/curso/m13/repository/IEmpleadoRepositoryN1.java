package com.curso.m13.repository;

import java.util.List;

import com.curso.m13.model.Empleado;

public interface IEmpleadoRepositoryN1 {

	  List<Empleado> findAll() ;

      Empleado findById(int id) ;

      boolean deleteById(int id) ;

      void save(Empleado empleadoDto) ;
;}
