package com.curso.m13.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.m13.dto.EmpleadoDto;
import com.curso.m13.repository.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private final IEmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(IEmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }
    
    public List<EmpleadoDto> findAll() {
        return empleadoRepository.findAll();
    }

    public EmpleadoDto findAllById(int id) {
    	return empleadoRepository.findAllById(id);
    }

    public boolean deletebyId(int id) {
       return empleadoRepository.deletebyId(id);
    }

    public void saveOrUpdate(EmpleadoDto empleadoDto) {
          empleadoRepository.saveOrUpdate(empleadoDto);
    }   

}
