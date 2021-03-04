package com.vehicles.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.project.Bike;
import com.vehicles.project.Car;
import com.vehicles.project.Wheel;
import com.vehicles.project.N2.Conductor;
import com.vehicles.project.N2.Llicencia;
import com.vehicles.project.N2.Titular;
import com.vehicles.project.N2.Truck;

public class Nivell2 {

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
	private static Truck camio;
	private static String nom;
	private static String cognom;
	private static String dataNaixement;
	private static String isTeAsseguranca;
	private static String isTeGaratge;
	private static Titular titular;
	private static Conductor conductor;
	private static String llicenciaTipus;
	private static String llicenciaData;
	private static String esTitular;

	static void Process() throws Exception {

		System.out.println("Milestone 2");

		/**
		 * Primer és crea el conductor i si aquest té llicencia, es crea el vehicle
		 * finalment si el conductor es també es titular es recull si te parking i
		 * garatge sino es crear un nou Titular.
		 **/

		/* Crear Conductor */
		nom = (JOptionPane.showInputDialog("Introdueix el Nom del Conductor: "));
		cognom = (JOptionPane.showInputDialog("Introdueix el Cognom del Conductor: "));
		dataNaixement = (JOptionPane.showInputDialog("Introdueix la data Naixement del Conductor: "));

		/* Crear LLicencia */
		do {
			llicenciaTipus = (JOptionPane
					.showInputDialog("Introdueix el Tipus de LLicencia: A (moto), B (cotxe), C (camio)")).toUpperCase();
			llicenciaData = (JOptionPane.showInputDialog("Introdueix data d'expiració de la LLicencia"));
		} while (!llicenciaTipus.equals("A") && !llicenciaTipus.equals("B") && !llicenciaTipus.equals("C"));

		Llicencia llicencia = new Llicencia(llicenciaTipus, nom + " " + cognom, llicenciaData);
		conductor = new Conductor(nom, cognom, dataNaixement, llicencia);
		System.out.println(conductor.toString());

		/* Crear Vehicle */
		do {
			tipusVehicle = (JOptionPane
					.showInputDialog("Vols crear un cotxe, una moto o un camio, introdueix; C ó M ó T")).toUpperCase();
		} while (!tipusVehicle.equals("C") && !tipusVehicle.equals("M") && !tipusVehicle.equals("T"));

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

			if (tipusVehicle.equals("T")) {
				camio = new Truck(matricula, marca, color);
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
			} else if (tipusVehicle.equals("T")) {
				camio.addWheels(rodes1, rodes2);
				System.out.println(camio.toString());
			} else {
				moto.addTwoWheels(rodes2);
				System.out.println(moto.toString());
			}

			esTitular = (JOptionPane.showInputDialog("El Conductor és també el Titular: S ó N ")).toUpperCase();

			if (esTitular.equals("S")) {
				isTeAsseguranca = (JOptionPane.showInputDialog("El Titular té aseguranca: S o N")).toUpperCase();
				isTeGaratge = (JOptionPane.showInputDialog("El Titular té parking: S o N")).toUpperCase();
			} else {
				/* Crear Nuevo Titular */
				nom = (JOptionPane.showInputDialog("Introdueix el Nom del Titular: "));
				cognom = (JOptionPane.showInputDialog("Introdueix el Cognom del Titular: "));
				dataNaixement = (JOptionPane.showInputDialog("Introdueix la data Naixement del Titular: "));
				isTeAsseguranca = (JOptionPane.showInputDialog("El Titular té aseguranca: S o N")).toUpperCase();
				isTeGaratge = (JOptionPane.showInputDialog("El Titular té parking: S o N")).toUpperCase();
			}

			titular = new Titular(nom, cognom, dataNaixement, isTeAsseguranca.equals("S"), isTeGaratge.equals("S"));
			System.out.println(titular.toString());

			compareLlicenciaToVechicleCreated(llicenciaTipus, tipusVehicle);

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

	static void compareLlicenciaToVechicleCreated(String llicencia, String vehicle) throws Exception {
		// if (!llicencia.getTipusLlicencia().matches("^[A,B,C]{1}")) {

		switch (llicencia) {
		case "A":
			if (!vehicle.equals("M"))
				throw new Exception("Només pots conduir una moto amb la llicència ; " + llicencia);
			break;
		case "B":
			if (!vehicle.equals("C"))
				throw new Exception("Només pots conduir un cotxe amb la llicència ; " + llicencia);
			break;
		case "C":
			if (!vehicle.equals("T"))
				throw new Exception("Només pots conduir un camió amb la llicència ; " + llicencia);
			break;
		default:
			throw new Exception("La llicència a de ser del tipus A, B o C");
		}

	}
}
