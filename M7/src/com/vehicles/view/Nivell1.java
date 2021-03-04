package com.vehicles.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;
import com.vehicles.project.N2.Truck;

public class Nivell1 {

	private static String matricula;
	private static String marca;
	private static String color;
	private static Wheel roda;
	private static List<Wheel> rodes1 = new ArrayList<Wheel>();
	private static List<Wheel> rodes2 = new ArrayList<Wheel>();
	private static String rodaMarca;
	private static double rodaDiametre;
	private static String tipusVehicle;
	private static Car cotxe;
	private static Bike moto;

	static void Process() throws Exception {

		System.out.println("Milestone 1");

		do {
			tipusVehicle = (JOptionPane
					.showInputDialog("Vols crear un cotxe o una moto introdueix; C ó M")).toUpperCase();
		} while (!tipusVehicle.equals("C") && !tipusVehicle.equals("M"));

		matricula = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix la matricula: "));
		marca = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix la marca: "));
		color = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix el color: "));

		String tipusRoda = "Davant";
		try {
			if (tipusVehicle.equals("C")) {
				cotxe = new Car(matricula, marca, color);
				setWhells(tipusRoda, rodes1);
				tipusRoda = "Darrere";
			}

			if (tipusVehicle.equals("M")) {
				moto = new Bike(matricula, marca, color);
				tipusRoda = "Moto";
			}

			setWhells(tipusRoda, rodes2);

			if (tipusVehicle.equals("C")) {
				cotxe.addWheels(rodes1, rodes2);
				System.out.println(cotxe.toString());
			} else {
				moto.addTwoWheels(rodes2);
				System.out.println(moto.toString());
			}

		} catch (

		Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
			System.exit(0);
		}

	}

	static void setWhells(String tipusRoda, List<Wheel> rodes) throws Exception {
		int i = 0;
		for (i = 0; i < 2; i++) {
			rodaMarca = (JOptionPane.showInputDialog("Rodes " + tipusRoda + ": Introdueix la marca: "));
			rodaDiametre = Double
					.parseDouble((JOptionPane.showInputDialog("Rodes " + tipusRoda + ": Introdueix la diametre: ")));
			roda = new Wheel(rodaMarca, rodaDiametre);
			rodes.add(roda);
		}

	}
}
