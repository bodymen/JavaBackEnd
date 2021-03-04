package com.vehicles.project.N3;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Wheel;
import com.vehicles.project.N2.Persona;
import com.vehicles.project.N2.Titular;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected Titular titular;
	protected List<Persona> listPersones;

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	
	public List<Persona> getListPerones() {
		return listPersones;
	}


	public void setListPerones(List<Persona> listPersones) {
		this.listPersones = listPersones;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}
}
