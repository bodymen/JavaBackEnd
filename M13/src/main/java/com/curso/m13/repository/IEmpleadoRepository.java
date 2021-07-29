package com.curso.m13.repository;

import java.util.List;

import com.curso.m13.dto.EmpleadoDto;

public interface IEmpleadoRepository {

	  List<EmpleadoDto> findAll() ;

      EmpleadoDto findAllById(int id) ;

      boolean deletebyId(int id) ;

      void saveOrUpdate(EmpleadoDto empleadoDto) ;
;}
