package com.curso.m13.dto;

import org.springframework.stereotype.Component;

//@Component
public class EmpleadoDto extends ResponseDto{

	//Integer
    private Integer id;
    private String nom;
    private Integer salari;
    private String puesto;
    
	public EmpleadoDto(Integer id, String nom, Integer salari, String puesto) {
		this.id = id;
		this.nom = nom;
		this.salari = salari;
		this.puesto = puesto;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public Integer getSalari() {
		return salari;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setSalari(Integer salari) {
		this.salari = salari;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}