package com.vehicles.project;

public class Wheel {
	
	private String brand;
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	private double diameter;

	public Wheel(String brand, double diameter) throws Exception {
		this.brand = brand;
		if(diameter<0.4 || diameter>4)
			throw new Exception("La mida a de ser superior a 0.4 i inferior a 4");
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Roda [marca=" + brand + ", diametre=" + diameter + "]";
	}
	
}
