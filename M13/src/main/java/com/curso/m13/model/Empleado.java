package com.curso.m13.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Empleado{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column
    private String nom;
	@Column
    private Integer salari;
	@Column
    private String puesto;
    
	public Empleado(Integer id, String nom, Integer salari, String puesto) {
		super();
		this.id = id;
		this.nom = nom;
		this.salari = salari;
		this.puesto = puesto;
	}
	
	public Empleado() {
		super();
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