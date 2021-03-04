package com.vehicles.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.project.Wheel;
import com.vehicles.project.N2.Conductor;
import com.vehicles.project.N2.Llicencia;
import com.vehicles.project.N2.Persona;
import com.vehicles.project.N2.Titular;
import com.vehicles.project.N3.Bike;
import com.vehicles.project.N3.Car;
import com.vehicles.project.N3.Truck;
import com.vehicles.project.N3.Vehicle;

public class Nivell3 {

	private static String matricula;
	private static String marca;
	private static String color;
	private static Wheel roda;
	private static List<Wheel> rodes1;
	private static List<Wheel> rodes2;
	private static String rodaMarca;
	private static double rodaDiametre;
	private static String tipusVehicle;
	protected static Car cotxe;
	protected static Bike moto;
	protected static Truck camio;
	private static String nom;
	private static String cognom;
	private static String dataNaixement;
	private static String isTeAsseguranca;
	private static String isTeGaratge;
	private static Titular titular;
	private static Conductor conductor;
	private static String llicenciaTipus;
	private static String llicenciaData;
	protected static ArrayList<Persona> listPersones;
	protected static ArrayList<Vehicle> listVehicles;
	private static String esConductor;
	private static String mesConductors;
	private static String sortir;

	static void Process() throws Exception {

		System.out.println("Milestone 3");
		do {

			/**
			 * Primer és crea el titular i , es crea el vehicle i les rodes. Despres si el
			 * titular es també es conductor es recull les dades i es comprova la llicencia.
			 * Finalment iterem per crear mes condutors i les seves llicencies. Asginem el
			 * titular al vehicle, i llista de persones al vehicle. I tornem al bucle
			 * general.
			 **/

			listPersones = new ArrayList<Persona>();
			listVehicles = new ArrayList<Vehicle>();
			rodes1 = new ArrayList<Wheel>();
			rodes2 = new ArrayList<Wheel>();

			try {

				createTitularAskForData();
				titular = new Titular(nom, cognom, dataNaixement, isTeAsseguranca.equals("S"), isTeGaratge.equals("S"));
				System.out.println(titular.toString());

				createVehicleAskForData();
				String tipusRoda = "Davant";
				if (tipusVehicle.equals("C")) {
					cotxe = new Car(matricula, marca, color);
					setWhells(tipusRoda, rodes1);
					tipusRoda = "Darrere";
					listVehicles.add(cotxe);
				}

				if (tipusVehicle.equals("T")) {
					camio = new Truck(matricula, marca, color);
					setWhells(tipusRoda, rodes1);
					tipusRoda = "Darrere";
					listVehicles.add(camio);
				}

				if (tipusVehicle.equals("M")) {
					/* Si es moto només té 1 llista de rodes, llavors no és crea */
					moto = new Bike(matricula, marca, color);
					tipusRoda = "Moto";
					listVehicles.add(moto);
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

				esConductor = (JOptionPane.showInputDialog("El Titular és també el Conductor?: S ó N ")).toUpperCase();

				if (esConductor.equals("S")) {
					conductor = new Conductor(titular.name, titular.cognom, titular.data,
							createLlicencia("el titular " + titular.name));
				} else {
					createConductorAskForData();
					conductor = new Conductor(nom, cognom, dataNaixement, createLlicencia(nom));
				}

				listPersones.add(conductor);
				System.out.println(conductor.toString());

				compareLlicenciaToVechicleCreated(llicenciaTipus, tipusVehicle);

				mesConductors = JOptionPane.showInputDialog("Vols crear més Conductors?: S ó N").toUpperCase();
				while (mesConductors.equals("S")) {
					createConductorAskForData();
					conductor = new Conductor(nom, cognom, dataNaixement, createLlicencia(nom));
					compareLlicenciaToVechicleCreated(llicenciaTipus, tipusVehicle);
					listPersones.add(conductor);
					System.out.println(conductor.toString());
					mesConductors = JOptionPane.showInputDialog("Vols crear més Conductors?: S ó N").toUpperCase();
				}

				assignTitularAndPersonesToVehicle();
				System.out.println("Titular i Conductors assignats al vehicle\n");

				sortir = (JOptionPane.showInputDialog("Vols sortir de la aplicació: S o N")).toUpperCase();

			} catch (

			Exception ex) {
				System.out.println("ERROR " + ex.getMessage());
				System.exit(0);
			}

		} while (!sortir.equals("S"));
	}

	private static void assignTitularAndPersonesToVehicle() {
		if (tipusVehicle.equals("C")) {
			cotxe.setTitular(titular);
			cotxe.setListPerones(listPersones);
		} else if (tipusVehicle.equals("T")) {
			camio.setTitular(titular);
			camio.setListPerones(listPersones);
		} else {
			moto.setTitular(titular);
			moto.setListPerones(listPersones);
		}
	}

	private static void createTitularAskForData() {
		nom = (JOptionPane.showInputDialog("Introdueix el Nom del Titular: "));
		cognom = (JOptionPane.showInputDialog("Introdueix el Cognom del Titular: "));
		dataNaixement = (JOptionPane.showInputDialog("Introdueix la data Naixement del Titular: dd/mm/yyyy "));
		isTeAsseguranca = (JOptionPane.showInputDialog("El Titular té aseguranca: S o N")).toUpperCase();
		isTeGaratge = (JOptionPane.showInputDialog("El Titular té parking: S o N")).toUpperCase();
	}

	private static void createVehicleAskForData() {
		do {
			tipusVehicle = (JOptionPane
					.showInputDialog("Vols crear un cotxe, una moto o un camio, introdueix; C ó M ó T")).toUpperCase();
		} while (!tipusVehicle.equals("C") && !tipusVehicle.equals("M") && !tipusVehicle.equals("T"));

		matricula = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix la matricula: "));
		marca = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix la marca: "));
		color = (JOptionPane.showInputDialog(tipusVehicle + ": Introdueix el color: "));
	}

	private static Llicencia createLlicencia(String name) throws Exception {
		do {
			llicenciaTipus = (JOptionPane.showInputDialog(
					"Introdueix el Tipus de LLicencia per " + name + " : A (moto), B (cotxe), C (camio)"))
							.toUpperCase();
			llicenciaData = (JOptionPane.showInputDialog("Introdueix data d'expiració de la LLicencia: dd/mm/yyyy"));
		} while (!llicenciaTipus.equals("A") && !llicenciaTipus.equals("B") && !llicenciaTipus.equals("C"));

		Llicencia llicencia = new Llicencia(llicenciaTipus, nom + " " + cognom, llicenciaData);
		return llicencia;
	}

	private static void createConductorAskForData() {
		nom = (JOptionPane.showInputDialog("Introdueix el Nom del Conductor: "));
		cognom = (JOptionPane.showInputDialog("Introdueix el Cognom del Conductor: "));
		dataNaixement = (JOptionPane.showInputDialog("Introdueix la data Naixement del Conductor: "));
	}

	static void setWhells(String tipusRoda, List<Wheel> rodes) throws Exception {
		int i = 0;
		for (i = 0; i < 2; i++) {
			rodaMarca = (JOptionPane.showInputDialog("Rodes " + tipusRoda + ": marca?: "));
			rodaDiametre = Double.parseDouble((JOptionPane.showInputDialog("Rodes " + tipusRoda + ": diametre?: ")));
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
