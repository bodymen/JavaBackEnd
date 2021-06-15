package com.flowers.controller;

import com.flowers.persistence.FloristeriaRepo;

import java.util.List;

import com.flowers.domain.Arbre;
import com.flowers.domain.Decoracio;
import com.flowers.domain.Material;
import com.flowers.domain.Flor;


public class FlowersController {

	public FlowersController() {
		
	}

	public void AfegirAbre(String nom, double preu, double altura) throws Exception {
		Arbre arbre = new Arbre(nom, preu, altura);
		this.myfloristeria.addArbres(arbre);
		
	}

	public void AfegirFlor(String nom, double preu, String color) throws Exception {
		Flor flor = new Flor(nom, preu, color);
		this.myfloristeria.addFlors(flor);
	}

	public void AfegirDecoracio(String nom, double preu, Material material) throws Exception {
		Decoracio decoracio = new Decoracio(nom, preu, material);
		this.myfloristeria.addDecoracio(decoracio);

	}
	
	public void RetirarAbre(Arbre arbre) throws Exception {
		this.myfloristeria.retirarAbre(arbre);
		
	}

	public void RetirarFlor(Flor flor) throws Exception {
		this.myfloristeria.retirarFlor(flor);
	}

	public void RetirarDecoracio(Decoracio decoracio) throws Exception {
		this.myfloristeria.retirarDecoracio(decoracio);

	}

	private FloristeriaRepo myfloristeria;

	public List<Arbre> getAllArbres() {
		return this.myfloristeria.getAllArbres();
	}

	public List<Flor> getAllFlors() {
		return this.myfloristeria.getAllFlors();
	}

	public List<Decoracio> getAllDecoracio() {
		return this.myfloristeria.getAllDecoracio();
	}

	public void crearFloristeria(String nom) {
		this.myfloristeria = new FloristeriaRepo(nom); 
		
	}

	
}
