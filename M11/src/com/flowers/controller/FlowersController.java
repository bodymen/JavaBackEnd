package com.flowers.controller;

import com.flowers.persistence.FloristeriaRepo;

import java.util.List;
import java.util.stream.Collectors;

import com.flowers.domain.Arbre;
import com.flowers.domain.Decoracio;
import com.flowers.domain.Material;
import com.flowers.domain.Flor;


public class FlowersController {

	private FloristeriaRepo myfloristeria;

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

	public FloristeriaRepo getMyfloristeria() {
		return myfloristeria;
	}

	public void setMyfloristeria(FloristeriaRepo myfloristeria) {
		this.myfloristeria = myfloristeria;
	}

	public int getStockArbre()
	{
		return this.myfloristeria.getStockArbre();
	}
	
	public int getStockFlor()
	{
		return this.myfloristeria.getStockFlor();
	}
	
	public int getStockDecoracio()
	{
		return this.myfloristeria.getStockDecoracio();
	}

	public Arbre getArbre(String nom) {
		return (Arbre) this.myfloristeria.getAllArbres().stream()
				.filter(a -> a.getNom().toUpperCase().equals(nom.toUpperCase()))
				.collect(Collectors.toList()).get(0);
	} 
	
	public Flor getFlor(String nom) {
		return (Flor) this.myfloristeria.getAllFlors().stream()
				.filter(a -> a.getNom().toUpperCase().equals(nom.toUpperCase()))
				.collect(Collectors.toList()).get(0);
	} 
	
	public Decoracio getDecoracio(String nom) {
		return (Decoracio) this.myfloristeria.getAllDecoracio().stream()	
				.filter(a -> a.getNom().toUpperCase().equals(nom.toUpperCase()))
				.collect(Collectors.toList()).get(0);
	} 
	
}
