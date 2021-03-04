package com.vehicles.project;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bike extends Vehicle {

	Pattern pat = Pattern.compile("^[\\d]{4}[a-zA-Z]{2,3}");
	Matcher mat;

	public Bike(String plate, String brand, String color) throws Exception {
		super(plate, brand, color);
		mat = pat.matcher(plate);
		if (!mat.matches())
			throw new Exception("La matricula ha de tenir 4 numeros i 2 o 3 lletres: " + plate);
	}

	public void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception("Només pot tenir dues rodes");

		Wheel rodaDavant = wheels.get(0);
		Wheel rodaDarrera = wheels.get(1);

		// if (!rightWheel.equals(leftWheel))
		if (!rodaDavant.getBrand().equals(rodaDarrera.getBrand())
				|| !Double.toString(rodaDavant.getDiameter()).equals(Double.toString(rodaDarrera.getDiameter())))
			throw new Exception("Les rodes han de ser iguals: " + wheels.toString());

		this.wheels.add(rodaDavant);
		this.wheels.add(rodaDarrera);
	}

	@Override
	public String toString() {
		return "Bike [matricula=" + plate + ", marca=" + brand + ", color=" + color + ", Rodes=" + wheels + "]\n";
	}

}
