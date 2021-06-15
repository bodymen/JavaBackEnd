package com.flowers.domain;

import java.util.ArrayList;
import java.util.List;
import com.flowers.domain.Arbre;
import com.flowers.domain.Decoracio;
import com.flowers.domain.Flor;

public class Floristeria {

	private List<Arbre> arbreList;
	private List<Flor> florList;
	private List<Decoracio> decoracioList;
	private String nom;
	

	int stockArbre;
	int stockFlor;
	int stockDecoracio;

	// constructor
	public Floristeria(String nom) {
		
		 this.nom = nom;
		
		 this.setArbreList(new ArrayList<>());
	     this.setFlorList(new ArrayList<>());
	     this.setDecoracioList(new ArrayList<>());
	     
	     this.stockArbre=0;
	     this.stockFlor=0;
	     this.stockDecoracio=0;
	     
	}
	
	public int getStockArbre() {
		return stockArbre;
	}


	public int getStockFlor() {
		return stockFlor;
	}


	public int getStockDecoracio() {
		return stockDecoracio;
	}


	public void setStockArbre(int stockArbre) {
		this.stockArbre = stockArbre ;
	}


	public void setStockFlor(int stockFlor) {
		this.stockFlor = stockFlor;
	}


	public void setStockDecoracio(int stockDecoracio) {
		this.stockDecoracio = stockDecoracio;
	}

	
	public List<Arbre> getArbreList() {
		return arbreList;
	}
	public void setArbreList(List<Arbre> arbreList) {
		this.arbreList = arbreList;
	}


	public List<Flor> getFlorList() {
		return florList;
	}


	public void setFlorList(List<Flor> florList) {
		this.florList = florList;
	}


	public List<Decoracio> getDecoracioList() {
		return decoracioList;
	}


	public void setDecoracioList(List<Decoracio> decoracioList) {
		this.decoracioList = decoracioList;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
