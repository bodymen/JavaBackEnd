package com.flowers.view;

import java.util.Scanner;


import com.flowers.controller.FlowersController;

import com.flowers.domain.Material;
import com.flowers.persistence.FloristeriaRepo;


public class InputManager {

	public InputManager() {
		this.scanner = new Scanner(System.in);
		this.commons = new InputCommons(this.scanner);
		this.controller = new FlowersController();
		this.view = new FlowersView();
		
	}

	public void close() {
		this.scanner.close();
	}

	public void showMenu()  {

		boolean exit = false;
		while (exit == false) {
			view.showMainMenu();
			int option = commons.askOption(1, 6);
			switch (option) {
			case 1:
				this.CrearFloristeria();
				break;
			case 2:
				this.AfegirArbre();
				break;
			case 3:
				this.AfegirFlor();
				break;
			case 4:
				this.AfegirDecoracio();
				break;
			case 5:
				this.ListProducte();
				break;
			case 6:
				exit = true;
				break;
			default:
				break;
			}
			if (exit == false) {
				commons.pause();
			} else {
				view.endProgram();
			}
		}

	}

	private void CrearFloristeria()  {

		this.nom = commons.askString("escriu el nom de la nova floristeria");
		this.controller.crearFloristeria(this.nom);
		System.out.println("la nova floristeria es diu: " + this.nom);
	}

	public String getNom() {
		return nom;
	}

	
	private void AfegirArbre() {
		// TODO Auto-generated method stub
		boolean correctFormat = false;
		while (correctFormat == false) {
			try {
				String nom = commons.askString("Escriu el nom de l'arbre:");
				double preu = commons.askDouble("Escriu el preu de l'arbre: ");
				double altura = commons.askDouble("Escriu l'alçada de l'arbre:");
				correctFormat = true;
				this.controller.AfegirAbre(nom, preu, altura);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades de l'arbre.");
			}
		}
	}

	private void AfegirFlor() {
		// TODO Auto-generated method stub
		boolean correctFormat = false;
		while (correctFormat == false) {
			try {
				String nom = commons.askString("Escriu el nom de la flor:");
				double preu = commons.askDouble("Escriu el preu de la flor: ");
				String color = commons.askString("Escriu el color de la flor:");
				correctFormat = true;
				this.controller.AfegirFlor(nom, preu, color);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades de l'arbre.");
			}
		}
	}

	private void AfegirDecoracio() {
		// TODO Auto-generated method stub
		boolean correctFormat = false;
		while (correctFormat == false) {
			try {
				String nom = commons.askString("Escriu el nom de la decoracio:");
				double preu = commons.askDouble("Escriu el preu de la decoracio: ");
				Material material = commons.askList("fusta o plastic");
				correctFormat = true;
				this.controller.AfegirDecoracio(nom, preu, material);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Torna a introduir les dades de l'arbre.");
			}
		}
	}
	private String ListProducte() {
		// TODO Auto-generated method stub

		StringBuilder inventario = new StringBuilder();
		inventario.append("\nArbres: \n");
		
//		myfloristeria.getAllArbres().forEach((arbre) -> inventario.append("\n"+arbre) );
//		inventario.append("\nFlors: \n");
//		myfloristeria.getAllFlors().forEach((flor) -> inventario.append("\n"+flor) );
//		inventario.append("\nDecoracio: \n");
//		myfloristeria.getAllDecoracio().forEach((decoracio) -> inventario.append("\n"+decoracio) );

		
		this.controller.getAllArbres().forEach((arbre) -> inventario.append("\n"+arbre) );
		inventario.append("\nFlors: \n");
		this.controller.getAllFlors().forEach((flor) -> inventario.append("\n"+flor) );
		inventario.append("\nDecoracio: \n");
		this.controller.getAllDecoracio().forEach((decoracio) -> inventario.append("\n"+decoracio) );
		
		return inventario.toString();

	}

	private Scanner scanner;
	private InputCommons commons;
	private FlowersView view;
	private FlowersController controller;
	private String nom;
	
}
