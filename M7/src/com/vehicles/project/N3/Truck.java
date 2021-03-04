package com.vehicles.project.N3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.vehicles.project.Wheel;

public class Truck extends Vehicle {

	Pattern pat = Pattern.compile("^[\\d]{4}[a-zA-Z]{2,3}");
	Matcher mat;

	public Truck(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
		mat = pat.matcher(plate);
		if (!mat.matches())
			throw new Exception("La matricula ha de tenir 4 numeros i 2 o 3 lletres: " + plate);

	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Només pot tenir dues rodes");

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);
		
		rightWheel.getDiameter();
		
		//if (!rightWheel.equals(leftWheel))
		if (!rightWheel.getBrand().equals(leftWheel.getBrand()) ||
			!Double.toString(rightWheel.getDiameter()).equals(Double.toString(leftWheel.getDiameter())))
			throw new Exception("Les rodes han de ser iguals: " + wheels.toString());

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}

	@Override
	public String toString() {
		return "Truck [matricula=" + plate + ", marca=" + brand + ", color=" + color + ", Rodes=" + wheels + "]";
	}

}
